package football.entities.field;

import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.player.Player;
import football.entities.player.Women;

public class ArtificialTurf extends BaseField{
    public ArtificialTurf(String name) {
        super(name, 150);
    }

    @Override
    public void addPlayer(Player player){
        if(!player.getClass().equals(Women.class)){
            throw new IllegalArgumentException(ConstantMessages
                    .FIELD_NOT_SUITABLE);
        }
        super.addPlayer(player);
    }
}
