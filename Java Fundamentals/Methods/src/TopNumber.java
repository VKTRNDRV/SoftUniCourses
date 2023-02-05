import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int endNum = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= endNum; i++) {
            if(isSumOfDigitsDivBy8(i) && isContainingOddDigit(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean isSumOfDigitsDivBy8(int num){
        String numString = Integer.toString(num);
        int sumOfAllDigits = 0;

        for (int i = 0; i < numString.length(); i++) {
            int currentDigit = Character.valueOf(numString.charAt(i));
            sumOfAllDigits += currentDigit;
        }
        return sumOfAllDigits % 8 == 0;

    }

    public static boolean isContainingOddDigit(int num){
        String numString = Integer.toString(num);

        for (int i = 0; i < numString.length(); i++) {
            int currentDigit = Character.valueOf(numString.charAt(i));

            if(currentDigit % 2 == 1){
                return true;
            }
        }
        return false;
    }
}
