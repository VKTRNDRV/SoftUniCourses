import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        boolean divBy2 = false;
        boolean divBy3 = false;
        boolean divBy6 = false;
        boolean divBy7 = false;
        boolean divBy10 = false;

        if(num % 2 == 0){divBy2 = true;}
        if(num % 3 == 0){divBy3 = true;}
        if(num % 6 == 0){divBy6 = true;}
        if(num % 7 == 0){divBy7 = true;}
        if(num % 10 == 0){divBy10 = true;}

        if(divBy10 == true){
            System.out.println("The number is divisible by 10");
        } else if (divBy7 == true){
            System.out.println("The number is divisible by 7");
        } else if (divBy6 == true) {
            System.out.println("The number is divisible by 6");
        } else if (divBy3 == true) {
            System.out.println("The number is divisible by 3");
        } else if (divBy2 == true) {
            System.out.println("The number is divisible by 2");
        } else{
            System.out.println("Not divisible");
        }
    }
}
