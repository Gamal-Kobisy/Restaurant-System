package observers;

import order.Order;

public class Waiter implements OrderObserver {
    @Override
    public void update(Order order) {
        System.out.println("Waiter Notification: New client comes and created an order");
    }
}