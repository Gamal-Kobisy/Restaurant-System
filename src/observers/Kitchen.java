package observers;

import order.Order;

public class Kitchen implements OrderObserver {
    @Override
    public void update(Order order) {
        System.out.println("Kitchen Notification: New order has been created Cook it!");
    }
}