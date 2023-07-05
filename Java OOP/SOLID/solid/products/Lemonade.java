package solid.products;

public class Lemonade implements Product, Drink{

    public static final double CALORIES_PER_100_GRAMS = 53.0;
    public static final double DENSITY = 0.7;

    private double milliliters;

    public Lemonade(double milliliters) {
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }

    @Override
    public double getCalories() {
        return (milliliters * DENSITY) * (CALORIES_PER_100_GRAMS/100);
    }

    @Override
    public double getAmountInLiters() {
        return milliliters / 1000;
    }

    @Override
    public double getAmount() {
        return getAmountInLiters() * DENSITY;
    }
}
