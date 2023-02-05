import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstNum = Integer.parseInt(scan.nextLine());
        int secondNum = Integer.parseInt(scan.nextLine());

        double firstFactorial = getFactorial(firstNum);
        double secondFactorial = getFactorial(secondNum);

        double result = (double) firstFactorial / secondFactorial;

        System.out.printf("%.2f",result);
    }

    public static double getFactorial(double num){
        double factorial = 1;

        for (double i = num; i >= 1; i--) {
            factorial *= i;
        }
        return factorial;
    }
}
