package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;

public class ShortHouse extends BaseHouse{
    public ShortHouse(String name) {
        super(name, 15);
    }

    @Override
    public void addCat(Cat cat) {
        if(!cat.getClass().getSimpleName().equals("ShorthairCat")){
            throw new IllegalArgumentException(
                    ConstantMessages.UNSUITABLE_HOUSE);
        }
        super.addCat(cat);
    }
}
