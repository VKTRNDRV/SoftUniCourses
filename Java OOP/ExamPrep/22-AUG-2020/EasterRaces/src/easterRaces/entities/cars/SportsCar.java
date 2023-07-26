package easterRaces.entities.cars;

import easterRaces.common.ExceptionMessages;

public class SportsCar extends BaseCar{
    private static final int CUBIC_CM = 3000;
    private static final int MIN_VALID_HORSEPOWER = 250;
    private static final int MAX_VALID_HORSEPOWER = 450;

    public SportsCar(String model, int horsePower) {
        super(model, horsePower, CUBIC_CM);
        if(horsePower < MIN_VALID_HORSEPOWER ||
                horsePower > MAX_VALID_HORSEPOWER){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.INVALID_HORSE_POWER, horsePower));
        }
    }
}
