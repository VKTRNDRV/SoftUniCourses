package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.entities.cat.Cat;

public class LongHouse extends BaseHouse{
    public LongHouse(String name) {
        super(name, 30);
    }

    @Override
    public void addCat(Cat cat) {
        if(!cat.getClass().getSimpleName().equals("LonghairCat")){
            throw new IllegalArgumentException(
                    ConstantMessages.UNSUITABLE_HOUSE);
        }
        super.addCat(cat);
    }
}
