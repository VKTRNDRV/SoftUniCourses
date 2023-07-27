package bakery.entities.drinks.interfaces;

public class Tea extends BaseDrink{

    private static final double PRICE = 2.5;

    public Tea(String name, int portion, String brand) {
        super(name, portion, PRICE, brand);
    }
}
