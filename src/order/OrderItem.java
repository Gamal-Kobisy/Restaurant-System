package order;

import menu.MenuItem;
import observers.OrderObserver;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {
    private MenuItem item;
    private int quantity;

    public OrderItem(MenuItem menItem, int qty) {
        item = menItem;
        quantity = qty;
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQty() {
        return quantity;
    }

    public double getSubTotal() {
        return item.getPrice() * quantity;
    }
}
