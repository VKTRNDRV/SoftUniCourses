package magicGame.models.region;

import magicGame.common.OutputMessages;
import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.Magic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RegionImpl implements Region{
    @Override
    public String start(Collection<Magician> magicians) {
        List<Magician> wizards = new ArrayList<>();
        List<Magician> blackWidows = new ArrayList<>();
        for(Magician magician : magicians){
            if(magician.getClass().equals(Wizard.class)){
                wizards.add(magician);
            }else if(magician.getClass().equals(BlackWidow.class)){
                blackWidows.add(magician);
            }
        }

        while(!wizards.isEmpty() && !blackWidows.isEmpty()){
            Wizard wizard = (Wizard) wizards.get(0);
            BlackWidow blackWidow = (BlackWidow) blackWidows.get(0);

            blackWidow.takeDamage(wizard.getMagic().fire());
            if (blackWidow.isAlive()){
                wizard.takeDamage(blackWidow.getMagic().fire());
                if (!wizard.isAlive()){
                    wizards.remove(wizard);
                }
            } else {
                blackWidows.remove(blackWidow);
            }
        }
        if (wizards.size() > blackWidows.size()){
            return "Wizards win!";
        } else {
            return "Black widows win!";
        }
    }
}
