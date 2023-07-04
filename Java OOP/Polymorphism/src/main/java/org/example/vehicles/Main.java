package org.example.vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] info = scanner.nextLine().split("\\s+");
        Car car = new Car(
                Double.parseDouble(info[1]),
                Double.parseDouble(info[2]),
                Double.parseDouble(info[3]));

        info = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(
                Double.parseDouble(info[1]),
                Double.parseDouble(info[2]),
                Double.parseDouble(info[3]));

        info = scanner.nextLine().split("\\s+");
        Bus bus = new Bus(
                Double.parseDouble(info[1]),
                Double.parseDouble(info[2]),
                Double.parseDouble(info[3]));

        int commandsLeft = Integer.parseInt(scanner.nextLine());
        while (commandsLeft-- > 0){
            info = scanner.nextLine().split("\\s+");
            if(info[0].equals("Drive")){
                try {
                    if (info[1].equals("Car")) {
                        System.out.println(car.driveDistance(Double.parseDouble(info[2])));
                    } else if (info[1].equals("Truck")) {
                        System.out.println(truck.driveDistance(Double.parseDouble(info[2])));
                    } else if (info[1].equals("Bus")) {
                        System.out.println(bus.driveDistance(Double.parseDouble(info[2]), true));
                    }
                }catch (Exception e){

                }
            } else if (info[0].equals("DriveEmpty")) {
                try {
                    System.out.println(bus.driveDistance(Double.parseDouble(info[2]), false));
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            } else if (info[0].equals("Refuel")){
                try {
                    if (info[1].equals("Car")) {
                        car.refuel(Double.parseDouble(info[2]));
                    } else if (info[1].equals("Truck")) {
                        truck.refuel(Double.parseDouble(info[2]));
                    } else if (info[1].equals("Bus")) {
                        bus.refuel(Double.parseDouble(info[2]));
                    }
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
