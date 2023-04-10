import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= size; i++) {
            printRow(i, size);
        }

        for (int i = size - 1; i > 0; i--){
            printRow(i, size);
        }

    }
    public static void printRow(int numOfStars, int maxSize){
        //printing indent spaces
        for (int i = 0; i < maxSize - numOfStars; i++) {
            System.out.print(" ");
        }

        //printing stars
        for (int i = 1; i < numOfStars; i++) {
            System.out.print("* ");
        }
        System.out.println("*");
    }
}