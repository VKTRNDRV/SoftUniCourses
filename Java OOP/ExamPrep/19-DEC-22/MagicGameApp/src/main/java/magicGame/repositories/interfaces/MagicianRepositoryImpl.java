package magicGame.repositories.interfaces;

import magicGame.common.ExceptionMessages;
import magicGame.models.magicians.Magician;
import magicGame.models.magics.Magic;

import java.util.ArrayList;
import java.util.Collection;

public class MagicianRepositoryImpl implements MagicianRepository<Magician> {

    private Collection<Magician> data;

    public MagicianRepositoryImpl(){
        this.data = new ArrayList<>();
    }

    @Override
    public Collection<Magician> getData() {
        return data;
    }

    @Override
    public void addMagician(Magician model) {
        if(model == null){
            throw new NullPointerException(ExceptionMessages
                    .INVALID_MAGICIAN_REPOSITORY);
        }
        data.add(model);
    }

    @Override
    public boolean removeMagician(Magician model) {
        if(data.contains(model)){
            data.remove(model);
            return true;
        }
        return false;
    }

    @Override
    public Magician findByUsername(String name) {
        return data.stream().filter(m -> m.getUsername().equals(name))
                .findFirst()
                .orElse(null);
    }
}
