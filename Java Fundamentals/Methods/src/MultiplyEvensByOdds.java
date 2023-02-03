import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        int output = getEvenDigitsSum(num) * getOddDigitsSum(num);

        System.out.println(output);

    }

    public static int getEvenDigitsSum(int num){
        int sum = 0;
        String numStr = Integer.toString(num);

        if(numStr.startsWith("-")){

            for (int i = 1; i < numStr.length(); i++) {
                char currentDigitChar = numStr.charAt(i);
                int currentDigit = Character.getNumericValue(currentDigitChar);

                if (currentDigit % 2 == 0) {
                    sum += currentDigit;
                }
            }
            sum *= -1;

        }else {

            for (int i = 0; i < numStr.length(); i++) {
                char currentDigitChar = numStr.charAt(i);
                int currentDigit = Character.getNumericValue(currentDigitChar);

                if (currentDigit % 2 == 0) {
                    sum += currentDigit;
                }
            }
        }
        return sum;
    }

    public static int getOddDigitsSum(int num){
        int sum = 0;
        String numStr = Integer.toString(num);

        if(numStr.startsWith("-")){

            for (int i = 1; i < numStr.length(); i++) {
                char currentDigitChar = numStr.charAt(i);
                int currentDigit = Character.getNumericValue(currentDigitChar);

                if (currentDigit % 2 != 0) {
                    sum += currentDigit;
                }
            }
            sum *= -1;

        }else {

            for (int i = 0; i < numStr.length(); i++) {
                char currentDigitChar = numStr.charAt(i);
                int currentDigit = Character.getNumericValue(currentDigitChar);

                if (currentDigit % 2 != 0) {
                    sum += currentDigit;
                }
            }
        }
        return sum;
    }
}
