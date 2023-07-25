package onlineShop.core;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {

    private List<Computer> computers;

    private List<Component> components;

    private List<Peripheral> peripherals;

    private static List<Class<? extends BaseComponent>> COMPONENT_CLASSES = new ArrayList<>();

    public ControllerImpl() {
        this.computers = new ArrayList<>();
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        if(isComputerIdPresent(id)){
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPUTER_ID);
        }
        if(computerType.equals("DesktopComputer")){
            computers.add(new DesktopComputer(id, manufacturer, model, price));
        }else if (computerType.equals("Laptop")){
            computers.add(new Laptop(id, manufacturer, model, price));
        }else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPUTER_TYPE);
        }
        return String.format(OutputMessages.ADDED_COMPUTER, id);
    }

    private boolean isComputerIdPresent(int id){
        for (Computer computer : computers){
            if(computer.getId() == id){
                return true;
            }
        }
        return false;
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        if(getPeripheralById(id) != null){
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_PERIPHERAL_ID);
        }
        Computer computer = getComputerById(computerId);
        Peripheral peripheral = null;
        if(peripheralType.equals("Headset")){
            peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
        }else if(peripheralType.equals("Keyboard")){
            peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
        }else if(peripheralType.equals("Monitor")){
            peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
        }else if(peripheralType.equals("Mouse")){
            peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
        }else{
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PERIPHERAL_TYPE);
        }
        computer.addPeripheral(peripheral);
        this.peripherals.add(peripheral);
        return String.format(OutputMessages.ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    private Peripheral getPeripheralById(int id){
        for(Peripheral peripheral : peripherals){
            if(peripheral.getId() == id){
                return peripheral;
            }
        }
        return null;
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        Computer computer = getComputerById(computerId);
        Peripheral peripheral = null;
        for(Peripheral p : peripherals){
            if(p.getClass().getSimpleName().equals(peripheralType)){
                peripheral = p;
            }
        }
        computer.removePeripheral(peripheralType);
        this.peripherals.remove(peripheral);
        return String.format(OutputMessages.REMOVED_PERIPHERAL,
                peripheralType, peripheral.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        if(isComponentIdPresent(id)){
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPONENT_ID);
        }
        Computer computer = getComputerById(computerId);
        if(computer == null){
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        Component component = null;
        if(componentType.equals("CentralProcessingUnit")){
            component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
        }else if(componentType.equals("Motherboard")){
            component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
        }else if(componentType.equals("PowerSupply")){
            component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
        }else if(componentType.equals("RandomAccessMemory")){
            component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
        }else if(componentType.equals("SolidStateDrive")){
            component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
        }else if(componentType.equals("VideoCard")){
            component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
        }else{
            throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPONENT_TYPE);
        }
        components.add(component);
        computer.addComponent(component);
        return String.format(OutputMessages.ADDED_COMPONENT, componentType, id, computerId);
    }

    private boolean isComponentIdPresent(int id){
        for (Component component : components){
            if(component.getId() == id){
                return true;
            }
        }
        return false;
    }

    private Computer getComputerById(int id){
        for(Computer computer : computers){
            if (computer.getId() == id){
                return computer;
            }
        }
        return null;
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        Computer computer = getComputerById(computerId);
        if(computer == null){
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        Component component = null;
        for(Component comp : computer.getComponents()){
            if(comp.getClass().getSimpleName().equals(componentType)){
                component = comp;
            }
        }
        if(component == null){
            throw new IllegalArgumentException(
                    String.format(ExceptionMessages.NOT_EXISTING_COMPONENT,
                            componentType,
                            computer.getClass().getSimpleName(),
                            computerId));
        }
        computer.removeComponent(componentType);
        this.components.remove(component);
        return String.format(OutputMessages.REMOVED_COMPONENT,
                componentType, component.getId());
    }

    @Override
    public String buyComputer(int id) {
        Computer computer = getComputerById(id);
        if(computer == null){
            throw new IllegalArgumentException(
                    ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        this.computers.remove(computer);
        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        if(this.computers.size() == 0){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.CAN_NOT_BUY_COMPUTER, budget));
        }
        Computer computer = null;
        for(Computer c : computers){
            if(c.getPrice() <= budget){
                if(computer == null){
                    computer = c;
                    continue;
                }
                if(c.getOverallPerformance() > computer.getOverallPerformance()){
                    computer = c;
                }
            }
        }
        if(computer.getPrice() > budget){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.CAN_NOT_BUY_COMPUTER, budget));
        }else {
            this.computers.remove(computer);
            return computer.toString();
        }
    }

    @Override
    public String getComputerData(int id) {
        Computer computer = getComputerById(id);
        if(computer == null){
            throw new IllegalArgumentException(
                    ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        return getComputerById(id).toString();
    }
}
