package christmasPastryShop.entities.booths;

public class OpenBooth extends BaseBooth{

    private static double PRICE_PER_PERSON = 2.5;

    public OpenBooth(int boothNumber, int capacity) {
        super(boothNumber, capacity, PRICE_PER_PERSON);
    }
}
