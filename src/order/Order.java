package order;

import discount.DiscountStrategy;

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

    public void showOrderItems() {
        if (orderItems == null || orderItems.isEmpty()) {
            System.out.println("No items in this order yet.");
            return;
        }

        System.out.println("\n--- Order Items ---");
        int index = 1;
        double total = 0.0;

        for (order.OrderItem item : orderItems) {
            double itemTotal = item.getItem().getPrice() * item.getQty();
            System.out.printf(
                    "%d. %s – %s – Qty: %d – $%.2f%n",
                    index++,
                    item.getItem().getName(),
                    item.getItem().getDescription(),
                    item.getQty(),
                    itemTotal
            );
            total += itemTotal;
        }

        System.out.printf("Total: $%.2f%n", total);
    }

    public double calculateTotal(DiscountStrategy discountStrategy) {
        double total = 0.0;
        for (OrderItem item : orderItems) {
            total += item.getItem().getPrice() * item.getQty();
        }

        if (discountStrategy != null) {
            double discount = discountStrategy.applyDiscount(total);
            System.out.printf("Discount applied: $%.2f%n", discount);
            total -= discount;
        }

        return total;
    }

}
