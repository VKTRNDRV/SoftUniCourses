package bakery.repositories.interfaces;

import bakery.common.ExceptionMessages;
import bakery.entities.bakedFoods.interfaces.BakedFood;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class FoodRepositoryImpl implements FoodRepository<BakedFood>{

    private Collection<BakedFood> models;

    public FoodRepositoryImpl(){
        this.models = new ArrayList<>();
    }
    @Override
    public BakedFood getByName(String name) {
        for(BakedFood bakedFood : models){
            if(bakedFood.getName().equals(name)){
                return bakedFood;
            }
        }
        return null;
    }

    @Override
    public Collection<BakedFood> getAll() {
        return Collections
                .unmodifiableCollection(models);
    }

    @Override
    public void add(BakedFood bakedFood) {
        if(containsBakedFood(bakedFood)){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.FOOD_OR_DRINK_EXIST,
                    bakedFood.getClass().getSimpleName(),
                    bakedFood.getName()));
        }
        models.add(bakedFood);
    }

    private boolean containsBakedFood(BakedFood bakedFood){
        String name = bakedFood.getName();
        for(BakedFood food : models){
            if (food.getName().equals(name) && food.getClass().equals(bakedFood.getClass())){
                return true;
            }
        }
        return false;
    }
}
