package observers;

import order.Order;
import order.OrderItem;

public class Waiter implements OrderObserver {

    @Override
    public void update(Order order) {
        int count = order.getItemCount();
        double total = 0;

        for (OrderItem item : order.getItems()) {
            total += item.getItem().getPrice() * item.getQty();
        }

        System.out.println("\n🔔 Waiter Notification:");
        System.out.println("A new order has been taken.");
        System.out.println("Items: " + count + "   |   Estimated Total: $" + String.format("%.2f", total));
        System.out.println("Please attend to the customer.\n");
    }
}
