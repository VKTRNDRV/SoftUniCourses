package christmasPastryShop.repositories;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.repositories.interfaces.CocktailRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CocktailRepositoryImpl implements CocktailRepository<Cocktail> {

    private Collection<Cocktail> models;

    public CocktailRepositoryImpl(){
        this.models = new ArrayList<>();
    }

    @Override
    public Cocktail getByName(String name) {
        return models.stream().filter(c ->
                c.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Cocktail> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Cocktail cocktail) {
        if(containsCocktail(cocktail)){
            throw new IllegalArgumentException(String.format(ExceptionMessages
                            .FOOD_OR_DRINK_EXIST,
                    cocktail.getClass().getSimpleName(), cocktail.getName()));
        }
        this.models.add(cocktail);
    }

    private boolean containsCocktail(Cocktail cocktail){
        String name = cocktail.getName();
        for(Cocktail c : models){
            if(c.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
