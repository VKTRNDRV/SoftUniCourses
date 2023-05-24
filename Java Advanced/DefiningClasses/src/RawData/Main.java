package RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carsCount = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        //iterating all input lines
        while (carsCount > 0){
            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];

            int engineSpeed = Integer.parseInt(carData[1]);
            int enginePower = Integer.parseInt(carData[2]);

            int cargoWeight = Integer.parseInt(carData[3]);
            String cargoType = carData[4];

            double tire1Pressure = Double.parseDouble(carData[5]);
            int tire1Age = Integer.parseInt(carData[6]);
            double tire2Pressure = Double.parseDouble(carData[5]);
            int tire2Age = Integer.parseInt(carData[6]);
            double tire3Pressure = Double.parseDouble(carData[5]);
            int tire3Age = Integer.parseInt(carData[6]);
            double tire4Pressure = Double.parseDouble(carData[5]);
            int tire4Age = Integer.parseInt(carData[6]);

            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType,
                    tire1Pressure, tire1Age,
                    tire2Pressure, tire2Age,
                    tire3Pressure, tire3Age,
                    tire4Pressure, tire4Age);

            cars.add(car);

            carsCount--;
        }

        //filtering and printing
        String command = scanner.nextLine();
        if(command.equals("fragile")){
            cars = cars.stream()
                    .filter(car -> car.getCargo().getType().equals("fragile"))
                    .collect(Collectors.toList());

            for(int i = 0; i < cars.size(); i++){
                Car car = cars.get(i);
                boolean isFragile = false;
                Set<Tire> tires = car.getTires();
                for(Tire tire : tires){
                    if(tire.getPressure() < 1){
                        isFragile = true;
                        break;
                    }
                }

                if(!isFragile){cars.remove(car);}
                i--;
            }

            for(Car car : cars){
                System.out.println(car.getModel());
            }

        }
        else if(command.equals("flamable")){
            cars = cars.stream()
                    .filter(car -> car.getCargo().getType().equals("flamable"))
                    .filter(car -> car.getEngine().getPower() > 250)
                    .collect(Collectors.toList());

            for(Car car : cars){
                System.out.println(car.getModel());
            }
        }
    }
}
