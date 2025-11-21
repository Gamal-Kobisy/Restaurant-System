import java.util.ArrayList;
import java.util.List;

public class OrderNotifier {
    private List<OrderObserver> observers = new ArrayList<>();


    public void attach(OrderObserver observer) {
        observers.add(observer);
    }


    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }


    public void notifyAll(Order order) {
        for (OrderObserver observer : observers) {
            observer.update(order);
        }
    }
}