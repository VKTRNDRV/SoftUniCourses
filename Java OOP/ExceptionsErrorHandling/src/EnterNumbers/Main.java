package EnterNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Integer> numsList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = 1;
        int end = 100;
        int testNum = 0;

        while (numsList.size() < 10) {
            try {
                testNum = Integer.parseInt(scanner.nextLine());
                readNumber(start, end, testNum);
                start = testNum;

            } catch (NumberFormatException e) {
                System.out.println("Invalid Number!");

            } catch (ArithmeticException e) {
                System.out.printf("Your number is not in range %d - 100!%n", start);
            }
        }

        for (int i = 0; i < numsList.size(); i++) {
            if(i != numsList.size() - 1){
                System.out.printf("%d, ", numsList.get(i));
            }else{
                System.out.print(numsList.get(i));
            }
        }
    }

    public static void readNumber(int start, int end, int testNum){
        if(testNum > start && testNum < end){
            numsList.add(testNum);

        }else{
            throw new ArithmeticException("num not in index");
        }
    }
}
