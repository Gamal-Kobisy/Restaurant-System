package decorator;

import menu.MenuItem;

public class ExtraSauce extends AddOnDecorator {
    private double addPrice = 1.0;

    public ExtraSauce(MenuItem baseItem) {
        super(baseItem);
    }

    @Override
    public String getName(){
        return baseItem.getName() + "+ Extra Sauce";
    }

    @Override
    public double getPrice(){
        return baseItem.getPrice() + addPrice;
    }
}
