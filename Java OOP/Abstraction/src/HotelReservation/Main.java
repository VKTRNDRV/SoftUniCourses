package HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArr = scanner.nextLine().split(" ");

        double pricePerDay = Double.parseDouble(inputArr[0]);
        int numOfDays = Integer.parseInt(inputArr[1]);
        PriceCalculator.Season season = PriceCalculator.Season.valueOf(inputArr[2]);
        PriceCalculator.Discount discount = PriceCalculator.Discount.valueOf(inputArr[3]);

        System.out.printf("%.2f", PriceCalculator.calculatePrice(pricePerDay, numOfDays, season, discount));

    }
}
