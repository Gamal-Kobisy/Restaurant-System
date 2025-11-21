package decorator;

import menu.MenuItem;

public class ExtraCheese extends AddOnDecorator {
    private double addPrice = 2.0;

    public ExtraCheese(MenuItem baseItem) {
        super(baseItem);
    }

    @Override
    public String getName(){
        return baseItem.getName() + "+ Extra Cheese";
    }

    @Override
    public double getPrice(){
        return baseItem.getPrice() + addPrice;
    }
}
