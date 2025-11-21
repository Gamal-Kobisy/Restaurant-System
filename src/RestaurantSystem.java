public class RestaurantSystem {
    private static RestaurantSystem instance; // Singleton instance
    private MenuFactory menuFactory;
    private OrderNotifier notifier = new OrderNotifier();


    // Private constructor prevents external instantiation
    private RestaurantSystem(MenuFactory menuFactory) {
        this.menuFactory = menuFactory;
    }


    // Static method to get the singleton instance
    public static synchronized RestaurantSystem getInstance(MenuFactory menuFactory) {
        if (instance == null) {
            instance = new RestaurantSystem(menuFactory);
        }
        return instance;
    }


    public void displayMenu() {
        Menu menu = menuFactory.createMenu();
        menu.showMenu();
    }


    public Order createOrder() {
        return new Order();
    }


    public void checkout(Order order, PaymentStrategy payment, DiscountStrategy discount) {
        double total = order.calculateTotal(discount);
        if (payment != null) {
            payment.payment(total);
        }
        notifier.notifyAll(order);
    }


    public OrderNotifier getNotifier() {
        return notifier;
    }
}