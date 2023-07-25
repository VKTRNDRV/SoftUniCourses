package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseComputer extends BaseProduct implements Computer{


    private List<Component> components;
    private List<Peripheral> peripherals;

    public BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return peripherals;
    }

    @Override
    public void addComponent(Component component) {
        for(Component comp : components){
            if (comp.getClass().getSimpleName()
                    .equals(component.getClass().getSimpleName())){
                throw new IllegalArgumentException(String.format(
                        "Component %s already exists in %s with Id %d.",
                        component.getClass().getSimpleName(),
                        this.getClass().getSimpleName(), this.getId()));
            }
        }
        this.components.add(component);
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        for(Peripheral periph : peripherals){
            if (periph.getClass().getSimpleName()
                    .equals(peripheral.getClass().getSimpleName())){
                throw new IllegalArgumentException(String.format(
                        "Peripheral %s already exists in %s with Id %d.",
                        peripheral.getClass().getSimpleName(),
                        this.getClass().getSimpleName(), this.getId()));
            }
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Component removeComponent(String componentType) {
        for(Component component : components){
            if(component.getClass().getSimpleName().equals(componentType)){
                this.components.remove(component);
                return component;
            }
        }
        throw new IllegalArgumentException(String.format(
                "Component %s does not exist in %s with Id %d.",
                componentType, this.getClass().getSimpleName(), this.getId()));
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        for(Peripheral peripheral : peripherals){
            if(peripheral.getClass().getSimpleName().equals(peripheralType)){
                peripherals.remove(peripheral);
                return peripheral;
            }
        }
        throw new IllegalArgumentException(String.format(
                "Peripheral %s does not exist in %s with Id %d.",
                peripheralType, this.getClass().getSimpleName(), this.getId()));
    }

    @Override
    public double getOverallPerformance(){
        double avgPerformance = 0;
        if(components.size() > 0){
            for(Component component : components){
                avgPerformance += component.getOverallPerformance();
            }
            avgPerformance /= components.size();
        }
        avgPerformance += super.getOverallPerformance();
        return avgPerformance;
    }

    @Override
    public double getPrice(){
        double total = super.getPrice();
        for(Peripheral peripheral : peripherals){
            total += peripheral.getPrice();
        }
        for(Component component : components){
            total += component.getPrice();
        }
        return total;
    }

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append(String.format(
                "Overall Performance: %.2f. Price: %.2f - %s: %s %s (Id: %d)\n",
                getOverallPerformance(), getPrice(),
                        this.getClass().getSimpleName(),
                        getManufacturer(), getModel(), getId()))
                .append(String.format(" Components (%d):\n",
                        components.size()));
        this.components.forEach(c -> output.append(
                String.format("  %s\n", c.toString())));

        output.append(String.format(
                " Peripherals (%d); Average Overall Performance (%.2f):\n",
                peripherals.size(),
                this.getPeripheralsAvgOverallPerformance()));

        this.peripherals.forEach(p -> output.append(
                String.format("  %s\n", p.toString())));
        return output.toString().trim();
    }

    private double getPeripheralsAvgOverallPerformance(){
        if(this.peripherals.size() == 0){
            return 0;
        }
        double avg = 0;
        for(Peripheral peripheral : this.peripherals){
            avg += peripheral.getOverallPerformance();
        }
        avg /= peripherals.size();
        return avg;
    }
}
