package discount;

public class ChickenDiscount implements DiscountStrategy {
    private double percentage = 0.85;

    public ChickenDiscount () {
        this.percentage = percentage;
    }
    @Override
    public double applyDiscount(double price) {
        return price * (1 -  percentage);
    }
}
