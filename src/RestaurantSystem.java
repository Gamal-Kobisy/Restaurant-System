import discount.DiscountStrategy;
import factories.MenuFactory;
import menu.Menu;
import order.Order;
import order.OrderItem;
import order.OrderNotifier;
import payment.PaymentStrategy;

import java.util.HashMap;
import java.util.Map;

public class RestaurantSystem {
    private static final Map<Class<? extends MenuFactory>, RestaurantSystem> instances = new HashMap<>();

    private MenuFactory menuFactory;
    private OrderNotifier notifier = new OrderNotifier();

    private RestaurantSystem(MenuFactory menuFactory) {
        this.menuFactory = menuFactory;
    }

    public static RestaurantSystem getInstance(MenuFactory factory) {
        Class<? extends MenuFactory> key = factory.getClass();
        if (!instances.containsKey(key)) {
            instances.put(key, new RestaurantSystem(factory));
        }
        return instances.get(key);
    }

    public void displayMenu() {
        Menu menu = menuFactory.createMenu();
        menu.showMenu();
    }

    public Order createOrder() {
        return new Order();
    }

    public void checkout(Order order, PaymentStrategy payment, DiscountStrategy discount) {
        notifier.notifyAll(order);
        double total = order.calculateTotal(discount);
        if (payment != null) {
            payment.payment(total);
        }
    }

    public OrderNotifier getNotifier() {
        return notifier;
    }
}