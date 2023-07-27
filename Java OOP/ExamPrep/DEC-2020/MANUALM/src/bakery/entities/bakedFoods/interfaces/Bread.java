package bakery.entities.bakedFoods.interfaces;

public class Bread extends BaseFood{

    private static final double INITIAL_PORTION = 200;


    public Bread(String name, double price) {
        super(name, INITIAL_PORTION, price);
    }
}
