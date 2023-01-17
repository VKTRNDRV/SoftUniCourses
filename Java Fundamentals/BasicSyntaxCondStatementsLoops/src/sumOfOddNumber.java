import java.util.Scanner;

public class sumOfOddNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputNum = Integer.parseInt(scan.nextLine());
        int sum = 0;

        int currentnum = 1;
        int i = 1;
        while(i <= inputNum) {
            System.out.println(currentnum);
            sum += currentnum;
            currentnum += 2;
            i++;
        }
        System.out.printf("Sum: %d",sum);
    }
}
