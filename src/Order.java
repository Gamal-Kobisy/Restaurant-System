import java.util.ArrayList;

public class Order {
    protected ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();

    public Order() {}

    public void addItem(OrderItem item){
        orderItems.add(item);
    }

    public void removeItem(OrderItem item){
        orderItems.remove(item);
    }

//    public void showOrderItems() {
//        for (OrderItem item : orderItems) {
//
//        }
//    }

    public double calculateTotal(DiscountStrategy discountStrategy) {
        double sum = 0.0;
        for (OrderItem item : orderItems) {
            sum += item.getSubTotal();
        }
        if (discountStrategy != null) {
            return discountStrategy.applyDiscount(sum);
        }
        return sum;
    }

}
