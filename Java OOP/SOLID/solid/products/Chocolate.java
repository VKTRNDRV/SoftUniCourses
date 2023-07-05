package solid.products;

public class Chocolate implements Product, Food{

    public static final double CALORIES_PER_100_GRAMS = 575.0;

    private double grams;

    public Chocolate(double grams) {
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }

    @Override
    public double getCalories() {
        return grams * (CALORIES_PER_100_GRAMS/100);
    }

    @Override
    public double getAmountInKG() {
        return grams/1000;
    }

    @Override
    public double getAmount() {
        return getAmountInKG();
    }
}
