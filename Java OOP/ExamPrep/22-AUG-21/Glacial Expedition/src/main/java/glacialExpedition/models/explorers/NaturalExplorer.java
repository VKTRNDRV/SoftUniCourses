package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{

    private static final double SEARCH_ENERGY_DECREASE = 7;
    private static final double INITIAL_ENERGY = 60;

    public NaturalExplorer(String name){
        super(name, INITIAL_ENERGY);
        setSearchEnergyDecrease(SEARCH_ENERGY_DECREASE);
    }
}
