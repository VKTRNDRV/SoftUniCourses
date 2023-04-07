package CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carsCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < carsCount; i++) {
            String[] carArr = scanner.nextLine().split(" ");
            if(carArr.length == 1){
                Car car = new Car(carArr[0]);
                System.out.println(car.carInfo());

            } else if (carArr.length == 3) {
                Car car = new Car(carArr[0], carArr[1], Integer.parseInt(carArr[2]));
                System.out.println(car.carInfo());
            }
        }
    }
}
