package HotelReservation;

import java.util.Scanner;

public class PriceCalculator {

    public enum Season{
        Spring(2), Summer(4), Autumn(1), Winter(3);

        private int value;
        Season(int value) {
            this.value = value;
        }
        public int getValue() {
            return this.value;
        }
    }

    public enum Discount{
        None(0), SecondVisit(10), VIP(20);
        private int value;
        Discount(int value) {
            this.value = value;
        }
        public int getValue() {
            return this.value;
        }
    }

    public static double calculatePrice(double pricePerDay, int numberOfDays, Season season, Discount discount) {
        int multiplier = season.getValue();
        double discountMultiplier = discount.getValue() / 100.0;
        double priceBeforeDiscount = numberOfDays * pricePerDay * multiplier;
        double discountedAmount = priceBeforeDiscount * discountMultiplier;
        return priceBeforeDiscount - discountedAmount;
    }

}
