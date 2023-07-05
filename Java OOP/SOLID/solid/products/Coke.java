package solid.products;

public class Coke implements Product, Drink{

    public static final double CALORIES_PER_100_GRAMS = 44.0;
    public static final double DENSITY = 0.6;

    private double milliliters;

    public Coke(double milliliters) {
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
    public double getAmount() {
        return getAmountInLiters() * DENSITY;
    }

    @Override
    public double getAmountInLiters() {
        return milliliters / 1000;
    }
}
