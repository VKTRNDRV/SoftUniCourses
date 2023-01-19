import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfChars = Integer.parseInt(scan.nextLine());
        int sum = 0;

        for (int l = 1; l <= numOfChars; l++){
            int currentCharCodeValue = scan.next().charAt(0);
            sum += currentCharCodeValue;
        }
        System.out.printf("The sum equals: %d",sum);
    }
}
