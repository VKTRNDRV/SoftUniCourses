import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= num ; i++){
            String currentNumString = new String(Integer.toString(i));
            int sumOfDigits = 0;
            for (int d = 0; d < currentNumString.length(); d++) {
                char currentDigitChar = currentNumString.charAt(d);
                String currentDigitString = Character.toString(currentDigitChar);
                int currentDigitInt = Integer.parseInt(currentDigitString);
                sumOfDigits += currentDigitInt;
            }
            if(sumOfDigits == 5 || sumOfDigits == 7 || sumOfDigits == 11){
                System.out.printf("%d -> True%n", i);
            }else{
                System.out.printf("%d -> False%n", i);
            }
        }
    }
}
