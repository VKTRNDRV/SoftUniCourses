package christmasPastryShop.entities.cocktails;

public class Hibernation extends BaseCocktail{

    private static double PRICE = 4.5;

    public Hibernation(String name, int size, String brand) {
        super(name, size, PRICE, brand);
    }
}
