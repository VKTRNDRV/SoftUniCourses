import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nightsBooked = Integer.parseInt(scan.nextLine()) - 1;
        String accommodationType = scan.nextLine();
        String evaluation = scan.next();

        double pricePerNight = 0.0;
        //calc pricePerNight
        switch (accommodationType){
            case "room for one person":
                pricePerNight = 18;
                break;
            case "apartment":
                pricePerNight = 25;
                break;
            case "president apartment":
                pricePerNight = 35;
                break;
            default:
                break;
        }

        double discountPriceAdjustment = 1;
        //calc discountPriceAdjustment
        if(nightsBooked < 10){
            switch (accommodationType) {
                case "room for one person":
                    discountPriceAdjustment -= 0;
                    break;
                case "apartment":
                    discountPriceAdjustment -= 0.3;
                    break;
                case "president apartment":
                    discountPriceAdjustment -= 0.1;
                    break;
                default:
                    break;
            }
        } else if (nightsBooked >= 10 && nightsBooked <= 15) {
            switch (accommodationType) {
                case "room for one person":
                    discountPriceAdjustment -= 0;
                    break;
                case "apartment":
                    discountPriceAdjustment -= 0.35;
                    break;
                case "president apartment":
                    discountPriceAdjustment -= 0.15;
                    break;
                default:
                    break;
            }
        } else if (nightsBooked > 15) {
            switch (accommodationType) {
                case "room for one person":
                    discountPriceAdjustment -= 0;
                    break;
                case "apartment":
                    discountPriceAdjustment -= 0.5;
                    break;
                case "president apartment":
                    discountPriceAdjustment -= 0.2;
                    break;
                default:
                    break;
            }
        }

        double totalPrice = nightsBooked * pricePerNight * discountPriceAdjustment;

        if("positive".equals(evaluation)){
            totalPrice *= 1.25;
        }else if("negative".equals((evaluation))){
            totalPrice *= 0.9;
        }

        System.out.printf("%.2f", totalPrice);
    }
}
