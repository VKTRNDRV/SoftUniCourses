package christmasPastryShop.entities.cocktails;

import christmasPastryShop.entities.cocktails.BaseCocktail;

public class MulledWine extends BaseCocktail {

    private static double PRICE = 3.5;
    public MulledWine(String name, int size, String brand) {
        super(name, size, PRICE, brand);
    }
}
