public class OrderItem {
    private MenuItem menuItem;
    private int quantity;

    public OrderItem(MenuItem menItem, int qty) {
        menuItem = menItem;
        quantity = qty;
    }

    public double getSubTotal(){
        return menuItem.getPrice() * quantity;
    }

}
