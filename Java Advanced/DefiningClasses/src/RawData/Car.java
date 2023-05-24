package RawData;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Set<Tire> tires;

    public Car(String model, int engineSpeed, int enginePower,
               int cargoWeight, String cargoType,
               double tire1Pressure, int tire1Age,
               double tire2Pressure, int tire2Age,
               double tire3Pressure, int tire3Age,
               double tire4Pressure, int tire4Age){

        this.model = model;

        this.engine = new Engine(engineSpeed, enginePower);

        this.cargo = new Cargo(cargoWeight, cargoType);

        this.tires = new HashSet<>();
        this.tires.add(new Tire(tire1Pressure, tire1Age));
        this.tires.add(new Tire(tire2Pressure, tire2Age));
        this.tires.add(new Tire(tire3Pressure, tire3Age));
        this.tires.add(new Tire(tire4Pressure, tire4Age));
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Set<Tire> getTires() {
        return tires;
    }

    public void setTires(Set<Tire> tires) {
        this.tires = tires;
    }
}
