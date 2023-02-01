import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();
        double firstNum = Integer.parseInt(scan.nextLine());
        double secondNum = Integer.parseInt(scan.nextLine());
        double result = 0;

        switch (command){
            case "add":
                result = add((int)firstNum,(int)secondNum);
                break;
            case "subtract":
                result = subtract((int)firstNum,(int)secondNum);
                break;
            case "multiply":
                result = multiply((int)firstNum,(int)secondNum);
                break;
            case "divide":
                result = divide(firstNum,secondNum);
                break;
        }

        System.out.printf("%.0f",result);
    }

    public static int add(int num1, int num2){
        return num1 + num2;
    }

    public static int subtract(int num1, int num2){
        return num1 - num2;
    }

    public static int multiply(int num1, int num2){
        return  num1 * num2;
    }

    public static double divide(double num1, double num2){
        return num1 / num2;
    }
}
