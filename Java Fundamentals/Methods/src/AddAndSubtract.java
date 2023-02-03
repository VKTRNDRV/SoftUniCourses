import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstNum = Integer.parseInt(scan.nextLine());
        int secondNum = Integer.parseInt(scan.nextLine());
        int thirdNum = Integer.parseInt(scan.nextLine());

        int output = subtract(getSum(firstNum,secondNum),thirdNum);

        System.out.println(output);

    }

    public static int getSum(int num1, int num2){
        return num1 + num2;
    }

    public static int subtract(int num1, int num2){
        return  num1 - num2;
    }
}
