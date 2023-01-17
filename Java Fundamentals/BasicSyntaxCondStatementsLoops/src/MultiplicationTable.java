import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputNum = Integer.parseInt(scan.nextLine());
        int secondNum = Integer.parseInt(scan.nextLine());

        if(secondNum <= 10){
            for (int i = secondNum; i <= 10; i++) {
                int currentResult = inputNum * i;
                System.out.printf("%d X %d = %d", inputNum, i, currentResult);
                System.out.println();
            }
        }else{
            System.out.printf("%d X %d = %d", inputNum, secondNum, (inputNum*secondNum));
        }
    }
}
