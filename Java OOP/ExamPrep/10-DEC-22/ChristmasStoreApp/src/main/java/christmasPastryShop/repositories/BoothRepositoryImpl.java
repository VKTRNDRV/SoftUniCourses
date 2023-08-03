package christmasPastryShop.repositories;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.repositories.interfaces.BoothRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BoothRepositoryImpl implements BoothRepository<Booth> {

    private Collection<Booth> models;

    public BoothRepositoryImpl(){
        this.models = new ArrayList<>();
    }

    @Override
    public Booth getByNumber(int number) {
        return models.stream().filter(b ->
                b.getBoothNumber() == number)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Booth> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Booth booth) {
        if(containsBooth(booth)){
            throw new IllegalArgumentException(String.format(ExceptionMessages
                    .BOOTH_EXIST, booth.getBoothNumber()));
        }
        this.models.add(booth);
    }

    private boolean containsBooth(Booth booth){
        int boothNum = booth.getBoothNumber();
        for(Booth b : models){
            if(b.getBoothNumber() == boothNum){
                return true;
            }
        }
        return false;
    }
}
