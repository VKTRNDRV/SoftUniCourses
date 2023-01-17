import java.util.Scanner;

public class SummerOutfit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int tempDegrees = Integer.parseInt(scan.nextLine());
        String timeOfDay = scan.nextLine();

        String outfit = new String();
        String shoes = new String();

        if(tempDegrees >= 10 && tempDegrees <= 18){
            switch (timeOfDay){
                case "Morning":
                    outfit = "Sweatshirt";
                    shoes = "Sneakers";
                    break;
                case "Afternoon":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
                case "Evening":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
                default:
                    break;
            }
        } else if(tempDegrees > 18 && tempDegrees <= 24){
            switch (timeOfDay){
                case "Morning":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
                case "Afternoon":
                    outfit = "T-Shirt";
                    shoes = "Sandals";
                    break;
                case "Evening":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
                default:
                    break;
            }
            
        } else if(tempDegrees > 24){
            switch (timeOfDay){
                case "Morning":
                    outfit = "T-Shirt";
                    shoes = "Sandals";
                    break;
                case "Afternoon":
                    outfit = "Swim Suit";
                    shoes = "Barefoot";
                    break;
                case "Evening":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
                default:
                    break;
            }
        }

        System.out.printf("It's %d degrees, get your %s and %s.", tempDegrees, outfit, shoes);
    }
}
