package factories;

import menu.Menu;
import menu.MenuItem;


public class VeganMenuFactory implements MenuFactory {
    @Override
    public Menu createMenu() {
        Menu menu = new Menu();
        menu.addItem(new MenuItem(
                "Vegan Burger",
                "Plant-based patty with lettuce, tomato, and vegan mayo.",
                95.0));

        menu.addItem(new MenuItem(
                "Tofu Stir Fry",
                "Stir-fried tofu with vegetables and soy sauce glaze.",
                90.0));

        menu.addItem(new MenuItem(
                "Vegan Salad",
                "Mixed greens, avocado, nuts, and citrus dressing.",
                80.0));
        return menu;
    }
}
