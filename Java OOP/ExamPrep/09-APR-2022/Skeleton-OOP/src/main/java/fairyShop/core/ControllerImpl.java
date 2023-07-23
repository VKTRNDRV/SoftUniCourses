package fairyShop.core;

import fairyShop.common.ConstantMessages;
import fairyShop.common.ExceptionMessages;
import fairyShop.models.Helper;
import fairyShop.models.Instrument;
import fairyShop.models.Present;
import fairyShop.models.Shop;
import fairyShop.models.impl.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;
import fairyShop.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ControllerImpl implements Controller{

    private Repository<Helper> helperRepository = new HelperRepository();
    private Repository<Present> presentRepository = new PresentRepository();
    private Shop shop = new ShopImpl();

    private int brokenInstrumentsCount = 0;
    @Override
    public String addHelper(String type, String helperName) {
        Helper helper;
        if(type.equals("Happy")){
            helper = new Happy(helperName);
        } else if (type.equals("Sleepy")) {
            helper = new Sleepy(helperName);
        }else {
            throw new IllegalArgumentException(
                    ExceptionMessages.HELPER_TYPE_DOESNT_EXIST);
        }

        helperRepository.add(helper);

        return String.format(ConstantMessages.ADDED_HELPER,
                type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper helper = helperRepository.findByName(helperName);
        if(helper == null){
            throw new IllegalArgumentException(
                    ExceptionMessages.HELPER_DOESNT_EXIST);
        }
        Instrument instrument = new InstrumentImpl(power);
        helper.addInstrument(instrument);
        return String.format(
                ConstantMessages.SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER
                , instrument.getPower()
                , helper.getName());
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        presentRepository.add(present);
        return String.format(ConstantMessages
                .SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        List<Helper> helpers = getHelpersWithEnergyAbove(50);
        if(helpers.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.NO_HELPER_READY);
        }
        Present present = presentRepository.findByName(presentName);

        for(Helper helper : helpers){
            int initialUnbrokenInstrumentsCount =
                    getCountOfUnbrokenInstruments(helper.getInstruments());
            this.shop.craft(present, helper);
            int endUnbrokenInstrumentsCount =
                    getCountOfUnbrokenInstruments(helper.getInstruments());
            brokenInstrumentsCount +=
                    initialUnbrokenInstrumentsCount -
                            endUnbrokenInstrumentsCount;
            if(present.isDone()){
                break;
            }
        }


        StringBuilder output = new StringBuilder();
        if(present.isDone()){
            output.append(String.format(ConstantMessages.PRESENT_DONE, present.getName(), "done"));
        }else {
            output.append(String.format(ConstantMessages.PRESENT_DONE, present.getName(), "not done"));
        }
        output.append(String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenInstrumentsCount));
        return output.toString().trim();
    }

    @Override
    public String report() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%d presents are done!\nHelpers info:\n",
                getCraftedPresentsCount()));
        for(Helper helper : helperRepository.getModels()){
            output.append(String.format("Name: %s\n", helper.getName()))
                    .append(String.format("Energy: %d\n", helper.getEnergy()))
                    .append(String.format("Instruments: %d not broken left\n",
                            getCountOfUnbrokenInstruments(helper.getInstruments())));
        }
        return output.toString().trim();
    }

    private int getCraftedPresentsCount(){
        int count = 0;
        for(Present present : presentRepository.getModels()){
            if (present.isDone()){
                count++;
            }
        }
        return count;
    }

//    private int getUnbrokenInstrumentsCount(Helper helper){
//        return (int) helper.getInstruments()
//                .stream()
//                .filter(i -> !i.isBroken())
//                .count();
//    }

    private List<Helper> getHelpersWithEnergyAbove(int energy){
        List<Helper> helpers = new ArrayList<>();
        for(Helper helper : helperRepository.getModels()){
            if (helper.getEnergy() > energy){
                helpers.add(helper);
            }
        }
        return helpers;
    }

    private int getCountOfUnbrokenInstruments(Collection<Instrument> instruments){
        int count = 0;
        for(Instrument instrument : instruments){
            if (!instrument.isBroken()){
                count++;
            }
        }
        return count;
    }
}
