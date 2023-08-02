package goldDigger.core;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.Repository;
import goldDigger.repositories.SpotRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ControllerImpl implements Controller{

    private Repository<Discoverer> discovererRepository;

    private Repository<Spot> spotRepository;

    private int inspectedSpotCount;

    public ControllerImpl(){
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
        this.inspectedSpotCount = 0;
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer = null;
        if(kind.equals("Anthropologist")){
            discoverer = new Anthropologist(discovererName);
        }else if(kind.equals("Archaeologist")){
            discoverer = new Archaeologist(discovererName);
        }else if(kind.equals("Geologist")){
            discoverer = new Geologist(discovererName);
        }else {
            throw new IllegalArgumentException(ExceptionMessages
                    .DISCOVERER_INVALID_KIND);
        }
        discovererRepository.add(discoverer);
        return String.format(ConstantMessages
                .DISCOVERER_ADDED,
                discoverer.getClass().getSimpleName(), discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);
        if(exhibits.length > 0){
            spot.getExhibits().addAll(Arrays.asList(exhibits));
        }
        spotRepository.add(spot);
        return String.format(ConstantMessages
                .SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = discovererRepository
                .byName(discovererName);
        if(discoverer == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages
                    .DISCOVERER_DOES_NOT_EXIST, discovererName));
        }
        discovererRepository.remove(discoverer);
        return String.format(ConstantMessages
                .DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        Spot spot = spotRepository.byName(spotName);
        Collection<Discoverer> discoverersToBeSent = new ArrayList<>();
        for(Discoverer discoverer : discovererRepository.getCollection()){
            if(discoverer.getEnergy() > 45){
                discoverersToBeSent.add(discoverer);
            }
        }
        if(discoverersToBeSent.size() == 0){
            throw new IllegalArgumentException(ExceptionMessages
                    .SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }
        Operation operation = new OperationImpl();
        operation.startOperation(spot, discoverersToBeSent);
        int excludedCount = 0;
        for(Discoverer discoverer : discoverersToBeSent){
            if(!discoverer.canDig()){
                excludedCount++;
            }
        }
        inspectedSpotCount++;
        return String.format(ConstantMessages
                .INSPECT_SPOT, spotName, excludedCount);
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append(String.format(ConstantMessages
                        .FINAL_SPOT_INSPECT, this.inspectedSpotCount))
                .append(System.lineSeparator())
                .append(ConstantMessages.FINAL_DISCOVERER_INFO)
                .append(System.lineSeparator());
        for(Discoverer discoverer : discovererRepository.getCollection()){
            output.append(String.format(ConstantMessages
                            .FINAL_DISCOVERER_NAME, discoverer.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages
                            .FINAL_DISCOVERER_ENERGY, discoverer.getEnergy()))
                    .append(System.lineSeparator());
            Collection<String> exhibits = discoverer
                    .getMuseum().getExhibits();
            String exhibitsStr = "";
            if(exhibits.size() > 0){
                exhibitsStr = String.join(ConstantMessages
                        .FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER,
                        exhibits);
            }else {
                exhibitsStr = "None";
            }
            output.append(String.format(ConstantMessages
                            .FINAL_DISCOVERER_MUSEUM_EXHIBITS, exhibitsStr))
                    .append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}
