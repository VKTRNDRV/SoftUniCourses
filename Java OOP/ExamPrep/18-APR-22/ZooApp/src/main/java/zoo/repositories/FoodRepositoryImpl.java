package zoo.repositories;

import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;

public class FoodRepositoryImpl implements FoodRepository{

    private Collection<Food> foods;

    public FoodRepositoryImpl(){
        this.foods = new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public boolean remove(Food food) {
        Food foodToRemove = findByType(food.getClass().getSimpleName());
        if(foodToRemove == null){
            return false;
        }
        return foods.remove(food);
    }

    @Override
    public Food findByType(String type) {
        return foods.stream().filter(food -> food
                        .getClass()
                        .getSimpleName()
                        .equals(type))
                .findFirst()
                .orElse(null);
    }
}
