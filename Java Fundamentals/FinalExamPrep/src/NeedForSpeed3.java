import java.util.*;

public class NeedForSpeed3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCars = Integer.parseInt(scanner.nextLine());
        int maxFuel = 75;
        int minMileage = 10000;
        int removeMileage = 100000;
        LinkedHashMap<String, List<Integer>> carsMap = new LinkedHashMap<>();
        for (int i = 0; i < numOfCars; i++) {
            String[] carArr = scanner.nextLine().split("\\|");
            String name = carArr[0];
            int mileage = Integer.parseInt(carArr[1]);
            int fuel = Integer.parseInt(carArr[2]);
            carsMap.put(name, new ArrayList<>());
            carsMap.get(name).add(mileage);
            carsMap.get(name).add(fuel);
        }

        while (true){
            String[] commandArr = scanner.nextLine().split(" [:] ");
            if (commandArr[0].equals("Stop")){break;}
            String command = commandArr[0];
            String carName = commandArr[1];
            switch (command){
                case "Drive":
                    int distanceDrivenKm = Integer.parseInt(commandArr[2]);
                    int fuelExhaused = Integer.parseInt(commandArr[3]);
                    int carMileageInitial = carsMap.get(carName).get(0);
                    int carFuel = carsMap.get(carName).get(1);
                    if(fuelExhaused <= carFuel){
                        carsMap.get(carName).set(0, carMileageInitial + distanceDrivenKm);
                        carsMap.get(carName).set(1, carFuel - fuelExhaused);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n"
                                , carName, distanceDrivenKm, fuelExhaused);

                        if(carMileageInitial + distanceDrivenKm >= removeMileage){
                            System.out.printf("Time to sell the %s!%n", carName);
                            carsMap.remove(carName);
                        }
                    }else{
                        System.out.println("Not enough fuel to make that ride");
                    }

                    break;

                case "Refuel":
                    int fuelAdd = Integer.parseInt(commandArr[2]);
                    int fuelInTank = carsMap.get(carName).get(1);
                    if(fuelAdd + fuelInTank <= maxFuel){
                        carsMap.get(carName).set(1, fuelInTank + fuelAdd);
                    }else{
                        fuelAdd = maxFuel - fuelInTank;
                        carsMap.get(carName).set(1, maxFuel);
                    }
                    System.out.printf("%s refueled with %d liters%n", carName, fuelAdd);

                    break;

                case "Revert":
                    int kilometersDecrease = Integer.parseInt(commandArr[2]);
                    int carMileage = carsMap.get(carName).get(0);
                    if(carMileage - kilometersDecrease >= minMileage){
                        carsMap.get(carName).set(0, carMileage - kilometersDecrease);
                        System.out.printf("%s mileage decreased by %d kilometers%n",carName, kilometersDecrease);
                    }else{
                        carsMap.get(carName).set(0, minMileage);
                    }
                    break;
            }
        }

        for(Map.Entry<String, List<Integer>> car : carsMap.entrySet()){
            String name = car.getKey();
            int mileage = car.getValue().get(0);
            int fuel = car.getValue().get(1);
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", name, mileage, fuel);
        }
    }
}
