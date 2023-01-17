import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int sum = 0;

        String numString = Integer.toString(num);

        for (int i = 0; i < numString.length(); i++) {
            char digitChar = numString.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            // calculate the factorial of the digit
            int factorial = 1;
            for (int j = 1; j <= digit; j++) {
                factorial *= j;
            }
            // add the factorial to the sum
            sum += factorial;
        }
        if(sum == num){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
