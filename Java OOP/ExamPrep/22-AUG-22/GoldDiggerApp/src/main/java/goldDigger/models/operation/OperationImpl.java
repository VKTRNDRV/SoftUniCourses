package goldDigger.models.operation;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.museum.Museum;
import goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OperationImpl implements Operation{
    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {
        Collection<String> spotExhibits = spot.getExhibits();
        List<String> exhibitsToRemove = null;
        for(Discoverer discoverer : discoverers){
            Collection<String> discovererExhibits = discoverer
                    .getMuseum().getExhibits();
            exhibitsToRemove = new ArrayList<>();
            for(String exhibit : spotExhibits){
                if(discoverer.canDig()){
                    discoverer.dig();
                    discovererExhibits.add(exhibit);
                    exhibitsToRemove.add(exhibit);
                }else {
                    break;
                }
            }
            exhibitsToRemove.forEach(spotExhibits::remove);
        }

    }
}
