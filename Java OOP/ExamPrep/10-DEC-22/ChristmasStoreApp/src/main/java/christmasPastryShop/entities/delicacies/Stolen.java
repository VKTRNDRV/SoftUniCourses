package christmasPastryShop.entities.delicacies;

public class Stolen extends BaseDelicacy{

    private static double INITIAL_PORTION = 250;

    public Stolen(String name, double price) {
        super(name, INITIAL_PORTION, price);
    }
}
