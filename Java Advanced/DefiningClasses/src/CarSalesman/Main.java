package CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int enginesCount = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        //reading all engines
        while (enginesCount > 0){
            String[] engineData = scanner.nextLine().split("\\s+");

            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);

            int displacement = -1;
            String efficiency = "n/a";
            if(engineData.length == 3){
                try {
                    displacement = Integer.parseInt(engineData[2]);
                }catch (Exception e){
                    efficiency = engineData[2];
                }
            }
            if(engineData.length == 4){
                displacement = Integer.parseInt(engineData[2]);
                efficiency = engineData[3];
            }

            Engine engine = new Engine(model, power, displacement, efficiency);
            engines.add(engine);

            enginesCount--;
        }

        //reading all cars
        int carsCount = Integer.parseInt(scanner.nextLine());
        while (carsCount > 0){
            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            String engineModel = carData[1];

            int weight = -1;
            String color = "n/a";
            if(carData.length == 3){
                try {
                    weight = Integer.parseInt(carData[2]);
                }catch (Exception e){
                    color = carData[2];
                }
            }
            if(carData.length == 4){
                weight = Integer.parseInt(carData[2]);
                color = carData[3];
            }

            //picking out engine
            Engine engine = null;
            for(Engine e : engines){
                if(e.getModel().equals(engineModel)){
                    engine = e;
                    break;
                }
            }

            Car car = new Car(model, engine, weight, color);
            cars.add(car);

            carsCount--;
        }

        for(Car car : cars){
            System.out.println(car.toString());
        }
    }
}
