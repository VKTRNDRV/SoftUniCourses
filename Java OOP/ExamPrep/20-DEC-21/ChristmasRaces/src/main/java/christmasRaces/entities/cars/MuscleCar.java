package christmasRaces.entities.cars;

import christmasRaces.common.ExceptionMessages;

public class MuscleCar extends BaseCar{

    private static double CUBIC_CM = 5000;
    private static int MIN_HP = 400;
    private static int MAX_HP = 600;
    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, CUBIC_CM);
        validateHorsePower(horsePower);
    }

    private void validateHorsePower(int horsePower) {
        if(horsePower < MIN_HP || horsePower > MAX_HP){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.INVALID_HORSE_POWER, horsePower));
        }
    }
}
