package menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    protected List<MenuItem> menuItems = new ArrayList<>();

    public Menu() {}

    public void addItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public MenuItem getItem(int itemNumber) {
        return menuItems.get(itemNumber);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void showMenu() {
        int idx = 1;
        for (MenuItem menuItem : menuItems) {
            System.out.println(idx + ") " + menuItem.getName() + ": " + menuItem.getPrice());
            System.out.println("Description: " + menuItem.getDescription());
            idx++;
        }
    }
}
