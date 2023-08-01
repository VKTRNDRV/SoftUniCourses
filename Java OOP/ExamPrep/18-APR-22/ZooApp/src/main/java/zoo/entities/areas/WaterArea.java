package zoo.entities.areas;

import zoo.common.ConstantMessages;
import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.areas.BaseArea;

public class WaterArea extends BaseArea {
    public WaterArea(String name) {
        super(name, 10);
    }

    @Override
    public void addAnimal(Animal animal) {
        if(!animal.getClass().equals(AquaticAnimal.class)){
            throw new IllegalStateException(ConstantMessages
                    .AREA_NOT_SUITABLE);
        }
        super.addAnimal(animal);
    }
}
