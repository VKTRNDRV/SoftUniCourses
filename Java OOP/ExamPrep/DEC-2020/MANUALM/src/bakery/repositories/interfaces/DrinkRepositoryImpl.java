package bakery.repositories.interfaces;

import bakery.common.ExceptionMessages;
import bakery.entities.drinks.interfaces.Drink;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class DrinkRepositoryImpl implements DrinkRepository<Drink>{

    private Collection<Drink> models;

    public DrinkRepositoryImpl(){
        this.models = new ArrayList<>();
    }
    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        for(Drink drink : models){
            if(drink.getName().equals(drinkName) &&
                    drink.getBrand().equals(drinkBrand)){
                return drink;
            }
        }
        return null;
    }

    @Override
    public Collection<Drink> getAll() {
        return Collections
                .unmodifiableCollection(models);
    }

    @Override
    public void add(Drink drink) {
        if(containsDrink(drink)){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.FOOD_OR_DRINK_EXIST,
                    drink.getClass().getSimpleName(),
                    drink.getName()));
        }
        models.add(drink);
    }

    private boolean containsDrink(Drink drink) {
        String name = drink.getName();
        String brand = drink.getBrand();
        for(Drink d : models){
            if (d.getName().equals(name)
                    && d.getBrand().equals(brand) && d.getClass().equals(drink.getClass())){
                return true;
            }
        }
        return false;
    }
}
