import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfPeople = Integer.parseInt(scan.nextLine());
        String groupType = scan.nextLine();
        String dayOfWeek = scan.nextLine();
        double pricePerNight = 0;
        double discountPriceAdjustment = 1;
        double totalPrice = 0;

        //calc pricePerNight
        switch (groupType){
            case "Students":
                switch (dayOfWeek){
                    case "Friday": pricePerNight = 8.45; break;
                    case "Saturday": pricePerNight = 9.8; break;
                    case "Sunday": pricePerNight = 10.46; break;
                }
                break;
            case "Business":
                switch (dayOfWeek){
                    case "Friday": pricePerNight = 10.9; break;
                    case "Saturday": pricePerNight = 15.60; break;
                    case "Sunday": pricePerNight = 16; break;
                }
                break;
            case "Regular":
                switch (dayOfWeek){
                    case "Friday": pricePerNight = 15; break;
                    case "Saturday": pricePerNight = 20; break;
                    case "Sunday": pricePerNight = 22.5; break;
                }
                break;
        }

        //calc discountPriceAdjustment
        if(groupType.equals("Students") && numOfPeople >= 30){
            discountPriceAdjustment -= 0.15;
        } else if (groupType.equals("Business") && numOfPeople >= 100) {
            numOfPeople -= 10;
        } else if (groupType.equals("Regular") && numOfPeople >= 10 && numOfPeople <= 20) {
            discountPriceAdjustment -= 0.05;
        }
        totalPrice = numOfPeople * pricePerNight * discountPriceAdjustment;

        System.out.printf("Total price: %.2f", totalPrice);

    }
}
