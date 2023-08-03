package magicGame.repositories.interfaces;

import magicGame.common.ExceptionMessages;
import magicGame.models.magicians.MagicianImpl;
import magicGame.models.magics.Magic;

import java.util.ArrayList;
import java.util.Collection;

public class MagicRepositoryImpl implements MagicRepository<Magic> {

    private Collection<Magic> data;

    public MagicRepositoryImpl(){
        this.data = new ArrayList<>();
    }

    @Override
    public Collection<Magic> getData() {
        return data;
    }

    @Override
    public void addMagic(Magic model) {
        if(model == null){
            throw new NullPointerException(ExceptionMessages
                    .INVALID_MAGIC_REPOSITORY);
        }
        data.add(model);
    }

    @Override
    public boolean removeMagic(Magic model) {
        if(data.contains(model)){
            data.remove(model);
            return true;
        }
        return false;
    }

    @Override
    public Magic findByName(String name) {
        return data.stream().filter(m -> m.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
