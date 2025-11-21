public class PizzaDiscount implements DiscountStrategy {
    private double percentage;

    public PizzaDiscount(double percentage) {
        this.percentage = percentage;
    }
    @Override
    public double applyDiscount(double price) {
        return price * (1 -  percentage);
    }
}
