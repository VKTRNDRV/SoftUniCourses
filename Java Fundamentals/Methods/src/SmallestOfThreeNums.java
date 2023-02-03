import java.util.Scanner;

public class SmallestOfThreeNums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstNum = Integer.parseInt(scan.nextLine());
        int secondNum = Integer.parseInt(scan.nextLine());
        int thirdNum = Integer.parseInt(scan.nextLine());

        int output = getSmallestOfThreeNums(firstNum,secondNum,thirdNum);

        System.out.println(output);

    }

    public static int getSmallestOfThreeNums(int num1, int num2, int num3){
        int smallest = num1;

        if(num2 < smallest){
            smallest = num2;
        }

        if(num3 < smallest){
            smallest = num3;
        }

        return smallest;
    }
}
