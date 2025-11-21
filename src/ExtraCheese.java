public class ExtraCheese extends AddOnDecorator {
    private double addPrice;

    public ExtraCheese(MenuItem baseItem , double addPrice) {
        super(baseItem);
        this.addPrice = addPrice;
    }

    @Override
    public String getName(){
        return baseItem.getName() + "+ ExtraCheese";
    }

    @Override
    public double getPrice(){
        return baseItem.getPrice() + addPrice;
    }
}
