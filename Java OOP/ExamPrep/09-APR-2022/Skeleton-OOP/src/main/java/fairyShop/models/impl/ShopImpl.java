package fairyShop.models.impl;

import fairyShop.models.Helper;
import fairyShop.models.Instrument;
import fairyShop.models.Present;
import fairyShop.models.Shop;

import java.util.Collection;

public class ShopImpl implements Shop {
    @Override
    public void craft(Present present, Helper helper) {
        Collection<Instrument> allInstruments = helper.getInstruments();
//        while(hasWorkingInstrument(allInstruments)
//                && helper.canWork() && !present.isDone()){
//
//            Instrument instrument = getInstrument(allInstruments);
//
//            while (!instrument.isBroken()
//                    && helper.canWork() && !present.isDone()){
//                helper.work();
//                instrument.use();
//                present.getCrafted();
//            }
//        }
        for(Instrument instrument : allInstruments){
            while (!instrument.isBroken() && !present.isDone() && helper.canWork()){
                helper.work();
                instrument.use();
                present.getCrafted();
            }
        }
    }

    private boolean hasWorkingInstrument(Collection<Instrument> instruments){
        for(Instrument instrument : instruments){
            if (!instrument.isBroken()){
                return true;
            }
        }
        return false;
    }

    private Instrument getInstrument(Collection<Instrument> instruments){
        for(Instrument instrument : instruments){
            if (!instrument.isBroken()){
                return instrument;
            }
        }
        return null;
    }
}
