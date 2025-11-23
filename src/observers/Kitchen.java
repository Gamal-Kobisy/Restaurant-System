package observers;

import order.Order;
import order.OrderItem;

public class Kitchen implements OrderObserver {

    @Override
    public void update(Order order) {

        System.out.println("\n🍳 Kitchen Notification:");
        System.out.println("A new order has arrived! Prepare the following:");

        for (OrderItem item : order.getItems()) {
            System.out.println("- " + item.getQty() + " x " + item.getItem().getName());
        }

        System.out.println("Start cooking!\n");
    }
}
