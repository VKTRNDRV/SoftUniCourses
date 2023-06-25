package FinalExam.automotiveRepairShop;

import java.util.ArrayList;
import java.util.List;

public class RepairShop {
    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){
        if(vehicles.size() < capacity){
            vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin){
        for(Vehicle vehicle : vehicles){
            if(vehicle.getVIN().equals(vin)){
                vehicles.remove(vehicle);
                return true;
            }
        }
        return false;
    }

    public int getCount(){
        return vehicles.size();
    }

    public Vehicle getLowestMileage(){
        Vehicle lowestMileageVehicle = null;
        int lowestMileage = 10000000;
        for (Vehicle vehicle : vehicles){
            if(vehicle.getMileage() < lowestMileage){
                lowestMileageVehicle = vehicle;
                lowestMileage = vehicle.getMileage();
            }
        }
        return lowestMileageVehicle;
    }

    public String report(){
        StringBuilder output = new StringBuilder();
        output.append("Vehicles in the preparatory:\n");
        for (Vehicle vehicle : vehicles){
            output.append(vehicle.toString())
                    .append(System.lineSeparator());
        }
        return output.toString().trim();
    }
}
