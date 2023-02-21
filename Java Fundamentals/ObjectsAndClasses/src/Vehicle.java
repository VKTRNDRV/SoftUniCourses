import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vehicle {
    private String type;
    private String model;
    private String color;
    private int horsePower;

    public Vehicle(String type, String model, String color, int horsePower){
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
    }

    public String getType(){return type;}
    public String getModel(){return model;}
    public String getColor(){return color;}
    public int getHorsePower(){return horsePower;}

    public void printData(){
        String capitalizedType;
        if(type.equals("car")){
            capitalizedType = "Car";
        }else{
            capitalizedType = "Truck";
        }

        System.out.printf("Type: %s%n", capitalizedType);
        System.out.printf("Model: %s%n", model);
        System.out.printf("Color: %s%n", color);
        System.out.printf("Horsepower: %d", horsePower);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Vehicle> vehiclesList = new ArrayList<>();
        while (true){
            String[] currentCommand = scan.nextLine().split(" ");
            if(currentCommand[0].equals("End")){
                break;
            }

            Vehicle currVehicle = new Vehicle
                    (currentCommand[0], currentCommand[1], currentCommand[2], Integer.parseInt(currentCommand[3]));
            vehiclesList.add(currVehicle);
        }

        while (true){
            String currentModel = scan.nextLine();
            if(currentModel.equals("Close the Catalogue")){
                break;
            }
            for(Vehicle vehicle : vehiclesList){
                if(vehicle.getModel().equals(currentModel)){
                    vehicle.printData();
                    System.out.println();
                }
            }
        }

        double averageHPCar = 0.0;
        int carsCount = 0;
        for(Vehicle vehicle : vehiclesList){
            if(vehicle.getType().equals("car")){
                averageHPCar += vehicle.getHorsePower();
                carsCount++;
            }
        }
        if(carsCount != 0) {averageHPCar /= carsCount;}
        System.out.printf("Cars have average horsepower of: %.2f.%n", averageHPCar);

        double averageHPTruck = 0.0;
        int trucksCount = 0;
        for(Vehicle vehicle : vehiclesList){
            if(vehicle.getType().equals("truck")){
                averageHPTruck += vehicle.getHorsePower();
                trucksCount++;
            }
        }
        if(trucksCount != 0) {averageHPTruck /= trucksCount;}
        System.out.printf("Trucks have average horsepower of: %.2f.", averageHPTruck);
    }
}
