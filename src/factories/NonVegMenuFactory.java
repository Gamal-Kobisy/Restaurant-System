package factories;

import menu.Menu;
import menu.MenuItem;

public class NonVegMenuFactory implements MenuFactory {

    @Override
    public Menu createMenu() {
        Menu menu = new Menu();

        menu.addItem(new MenuItem("Grilled Chicken",
                "Juicy grilled chicken breast with herbs and spices.",
                120.0));

        menu.addItem(new MenuItem("Beef Burger",
                "Thick beef patty with cheese, lettuce, and tomato.",
                100.0));

        menu.addItem(new MenuItem("Fried Fish",
                "Golden-fried fish fillet served with tartar sauce.",
                90.0));

        return menu;
    }
}