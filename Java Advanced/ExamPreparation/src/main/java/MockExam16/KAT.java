package MockExam16;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // reading input
        int[] line1 = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] line2 = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> allLicensePlates = new ArrayDeque<>();
        ArrayDeque<Integer> allCars = new ArrayDeque<>();
        for(int lp : line1){allLicensePlates.add(lp);}
        for(int c : line2){allCars.push(c);}
        int totalCarsRegistered = 0;
        int daysCount = 0;

        // iterating until empty
        while (!allLicensePlates.isEmpty() && !allCars.isEmpty()){
            daysCount++;
            int licensePlates = allLicensePlates.poll();
            int cars = allCars.pop();

            // perform move
            if(cars * 2 == licensePlates){
                totalCarsRegistered += cars;

            }else if(cars * 2 < licensePlates){
                totalCarsRegistered += cars;
                int leftoverLicensePlates = licensePlates - (2 * cars);
                allLicensePlates.add(leftoverLicensePlates);

            }else if(cars * 2 > licensePlates){
                int carsRegistered = licensePlates / 2;
                int leftoverCars = cars - carsRegistered;
                totalCarsRegistered += carsRegistered;
                allCars.add(leftoverCars);
            }
        }

        // printing output
        System.out.printf("%d cars were registered for %d days!\n"
                , totalCarsRegistered, daysCount);

        if (allCars.isEmpty() && allLicensePlates.isEmpty()){
            System.out.println("Good job! There is no queue in front of the KAT!");

        } else if (!allCars.isEmpty()) {
            int carsLeft = 0;
            while (!allCars.isEmpty()){
                carsLeft += allCars.pop();
            }
            System.out.printf("%d cars remain without license plates!", carsLeft);

        } else {
            int platesLeft = 0;
            while (!allLicensePlates.isEmpty()){
                platesLeft += allLicensePlates.poll();
            }
            System.out.printf("%d license plates remain!", platesLeft);
        }
    }
}
