package magicGame.core;

import magicGame.common.ExceptionMessages;
import magicGame.common.OutputMessages;
import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.BlackMagic;
import magicGame.models.magics.Magic;
import magicGame.models.magics.RedMagic;
import magicGame.models.region.Region;
import magicGame.models.region.RegionImpl;
import magicGame.repositories.interfaces.MagicRepositoryImpl;
import magicGame.repositories.interfaces.MagicianRepositoryImpl;

import java.util.*;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{

    private MagicRepositoryImpl magics;

    private MagicianRepositoryImpl magicians;

    private Region region;

    public ControllerImpl(){
        this.magics = new MagicRepositoryImpl();
        this.magicians = new MagicianRepositoryImpl();
        this.region = new RegionImpl();
    }


    @Override
    public String addMagic(String type, String name, int bulletsCount) {
        Magic magic = null;
        if(type.equals("RedMagic")){
            magic = new RedMagic(name, bulletsCount);
        }else if(type.equals("BlackMagic")){
            magic = new BlackMagic(name, bulletsCount);
        }else {
            throw new IllegalArgumentException(ExceptionMessages
                    .INVALID_MAGIC_TYPE);
        }
        magics.addMagic(magic);
        return String.format(OutputMessages
                .SUCCESSFULLY_ADDED_MAGIC, name);
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
        Magician magician = null;
        Magic magic = magics.findByName(magicName);
        if(magic == null){
            throw new NullPointerException(ExceptionMessages
                    .MAGIC_CANNOT_BE_FOUND);
        }
        if(type.equals("Wizard")){
            magician = new Wizard(username, health, protection, magic);
        }else if(type.equals("BlackWidow")){
            magician = new BlackWidow(username, health, protection, magic);
        }else {
            throw new IllegalArgumentException(ExceptionMessages
                    .INVALID_MAGICIAN_TYPE);
        }
        magicians.addMagician(magician);
        return String.format(OutputMessages
                .SUCCESSFULLY_ADDED_MAGICIAN, username);
    }

    @Override
    public String startGame() {
        return region.start(magicians.getData());
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        List<Magician> magicianList = magicians.getData().stream().sorted(Comparator.comparing(Magician::getHealth).thenComparing(Magician::getUsername)).collect(Collectors.toList());
        for (Magician magician : magicianList) {
            int health = magician.getHealth();
            if (magician.getHealth() < 0){
                health = 0;
            }
            int protection = magician.getProtection();
            if (magician.getProtection() < 0){
                protection = 0;
            }
            sb.append(String.format("%s: %s", magician.getClass().getSimpleName(), magician.getUsername())).append(System.lineSeparator())
                    .append(String.format("Health: %d", health)).append(System.lineSeparator())
                    .append(String.format("Protection: %d", protection)).append(System.lineSeparator())
                    .append(String.format("Magic: %s", magician.getMagic().getName())).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
