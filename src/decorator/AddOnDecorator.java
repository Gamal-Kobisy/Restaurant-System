package decorator;

import menu.MenuItem;

public abstract class AddOnDecorator extends MenuItem {
    protected MenuItem baseItem;

    public AddOnDecorator(MenuItem baseItem) {
        super(baseItem.getName() , baseItem.getDescription() , baseItem.getPrice());
        this.baseItem = baseItem;
    }
}
