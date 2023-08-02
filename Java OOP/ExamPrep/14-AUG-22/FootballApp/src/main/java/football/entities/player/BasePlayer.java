package football.entities.player;

import football.common.ExceptionMessages;

public abstract class BasePlayer implements Player{

    private String name;

    private String nationality;

    private double kg;

    private int strength;

    public BasePlayer(String name, String nationality, double kg, int strength){
        setName(name);
        setNationality(nationality);
        setKg(kg);
        setStrength(strength);
    }

    @Override
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages
                    .PLAYER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private int simulationStrengthIncrease;

    public void setSimulationStrengthIncrease(int simulationStrengthIncrease) {
        this.simulationStrengthIncrease = simulationStrengthIncrease;
    }

    protected void setNationality(String nationality) {
        if(nationality == null || nationality.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages
                    .PLAYER_NATIONALITY_NULL_OR_EMPTY);
        }
        this.nationality = nationality;
    }

    protected void setKg(double kg) {
        this.kg = kg;
    }

    protected void setStrength(int strength) {
        if(strength <= 0){
            throw new IllegalArgumentException(ExceptionMessages
                    .PLAYER_STRENGTH_BELOW_OR_EQUAL_ZERO);
        }
        this.strength = strength;
    }

    @Override
    public void stimulation() {
        this.strength += this.simulationStrengthIncrease;
    }

    @Override
    public double getKg() {
        return kg;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStrength() {
        return strength;
    }
}
