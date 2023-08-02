package football.core;


import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private SupplementRepository supplement;

    private Collection<Field> fields;

    public ControllerImpl(){
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field = null;
        if(fieldType.equals("ArtificialTurf")){
            field = new ArtificialTurf(fieldName);
        }else if(fieldType.equals("NaturalGrass")){
            field = new NaturalGrass(fieldName);
        }else {
            throw new NullPointerException(ExceptionMessages
                    .INVALID_FIELD_TYPE);
        }
        fields.add(field);
        return String.format(ConstantMessages
                .SUCCESSFULLY_ADDED_FIELD_TYPE,
                field.getClass().getSimpleName());
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supp = null;
        if(type.equals("Powdered")){
            supp = new Powdered();
        }else if(type.equals("Liquid")){
            supp = new Liquid();
        }else {
            throw new IllegalArgumentException(ExceptionMessages
                    .INVALID_SUPPLEMENT_TYPE);
        }
        supplement.add(supp);
        return String.format(ConstantMessages
                .SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE,
                supp.getClass().getSimpleName());
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement supp = supplement.findByType(supplementType);
        if(supp == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages
                    .NO_SUPPLEMENT_FOUND, supplementType));
        }
        Field field = getFieldByName(fieldName);
        supplement.remove(supp);
        field.addSupplement(supp);
        return String.format(ConstantMessages
                .SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD,
                supp.getClass().getSimpleName(), fieldName);
    }

    private Field getFieldByName(String name){
        return fields.stream().filter(f ->
                f.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player = null;
        if(playerType.equals("Men")){
            player = new Men(playerName, nationality, strength);
        }else if(playerType.equals("Women")){
            player = new Women(playerName, nationality, strength);
        }else {
            throw new IllegalArgumentException(ExceptionMessages
                    .INVALID_PLAYER_TYPE);
        }
        Field field = getFieldByName(fieldName);
        try {
            field.addPlayer(player);
        }catch (IllegalArgumentException e){
            return e.getMessage();
        }
        return String.format(ConstantMessages
                .SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = getFieldByName(fieldName);
        field.drag();
        return String.format(ConstantMessages
                .PLAYER_DRAG, field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = getFieldByName(fieldName);
        int totalStrength = 0;
        for(Player player : field.getPlayers()){
            totalStrength += player.getStrength();
        }
        return String.format(ConstantMessages
                .STRENGTH_FIELD, fieldName, totalStrength);
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        fields.forEach(f -> output.append(f.getInfo())
                .append(System.lineSeparator()));
        return output.toString().trim();
    }
}
