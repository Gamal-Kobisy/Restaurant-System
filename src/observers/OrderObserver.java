package observers;

import order.Order;

public interface OrderObserver {
    void update(Order order);
}
