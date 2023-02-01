import java.util.Scanner;

public class SignOfIntNums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputNum = Integer.parseInt(scan.nextLine());

        printSign(inputNum);

    }
    public static void printSign(int num) {
        if(num < 0){
            System.out.printf("The number %d is negative.",num);
        }else if(num > 0){
            System.out.printf("The number %d is positive.",num);
        }else{
            System.out.printf("The number %d is zero.",num);
        }
    }
}