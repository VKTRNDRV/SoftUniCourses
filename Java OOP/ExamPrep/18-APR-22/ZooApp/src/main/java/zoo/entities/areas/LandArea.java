package zoo.entities.areas;

import zoo.common.ConstantMessages;
import zoo.entities.animals.Animal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.BaseArea;

public class LandArea extends BaseArea {
    public LandArea(String name) {
        super(name, 25);
    }

    @Override
    public void addAnimal(Animal animal) {
        if(!animal.getClass().equals(TerrestrialAnimal.class)){
            throw new IllegalStateException(ConstantMessages
                    .AREA_NOT_SUITABLE);
        }
        super.addAnimal(animal);
    }
}
