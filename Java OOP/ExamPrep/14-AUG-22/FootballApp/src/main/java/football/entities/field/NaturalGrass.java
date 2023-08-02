package football.entities.field;

import football.common.ConstantMessages;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;

public class NaturalGrass extends BaseField{
    public NaturalGrass(String name) {
        super(name, 250);
    }


    @Override
    public void addPlayer(Player player){
        if(!player.getClass().equals(Men.class)){
            throw new IllegalArgumentException(ConstantMessages
                    .FIELD_NOT_SUITABLE);
        }
        super.addPlayer(player);
    }
}
