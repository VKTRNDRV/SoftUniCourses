package solid.products;

public class Chips implements Product, Food{

    public static final double CALORIES_PER_100_GRAMS = 529.0;
    private double grams;

    public Chips(double grams) {
        this.grams = grams;
    }

    @Override
    public double getCalories() {
        return grams * (CALORIES_PER_100_GRAMS/100);
    }

    @Override
    public double getAmount() {
        return getAmountInKG();
    }

    @Override
    public double getAmountInKG() {
        return grams / 1000;
    }
}
