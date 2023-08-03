package christmasPastryShop.repositories;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DelicacyRepositoryImpl implements DelicacyRepository<Delicacy> {

    private Collection<Delicacy> models;

    public DelicacyRepositoryImpl(){
        this.models = new ArrayList<>();
    }

    @Override
    public Delicacy getByName(String name) {
        return models.stream().filter(d ->
                d.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Delicacy> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Delicacy delicacy) {
        if(containsDelicacy(delicacy)){
            throw new IllegalArgumentException(String.format(ExceptionMessages
                    .FOOD_OR_DRINK_EXIST,
                    delicacy.getClass().getSimpleName(), delicacy.getName()));
        }
        this.models.add(delicacy);
    }

    private boolean containsDelicacy(Delicacy delicacy){
        String name = delicacy.getName();
        for(Delicacy d : models){
            if(d.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
