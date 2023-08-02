package football.entities.player;

public class Women extends BasePlayer{
    public Women(String name, String nationality, int strength) {
        super(name, nationality, 60, strength);
        setSimulationStrengthIncrease(115);
    }
}
