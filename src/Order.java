import java.util.ArrayList;

public class Order {
    private ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();

    public void addItem(OrderItem item){
        orderItems.add(item);
    }

    public void removeItem(OrderItem item){
        orderItems.remove(item);
    }

    public double calculateTotal(DiscountStrategy discountStrategy){
        double total = 0;
        for(OrderItem item : orderItems){
            total += item.getSubTotal();
        }
        double finalTotal = discountStrategy.applyDiscount(total);
        return finalTotal;
    }

}
