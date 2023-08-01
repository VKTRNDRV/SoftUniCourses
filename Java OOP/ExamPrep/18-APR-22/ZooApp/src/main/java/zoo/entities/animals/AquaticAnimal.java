package zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal{

    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, 2.5, price);
        setEatKgIncrease(7.5);
    }
}
