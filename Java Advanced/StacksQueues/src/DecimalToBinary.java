import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimalNum = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binaryNumStack = new ArrayDeque<>();

        int tempNum = decimalNum;
        while (tempNum != 0){
            binaryNumStack.push(tempNum % 2);
            tempNum /= 2;
        }

        if(decimalNum == 0){
            System.out.println(0);
        }else{
            while (!binaryNumStack.isEmpty()){
                System.out.print(binaryNumStack.pop());
            }
            System.out.println();
        }


    }
}
