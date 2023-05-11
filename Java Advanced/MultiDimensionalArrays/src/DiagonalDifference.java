import java.util.Map;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] squareArr = new String[size][size];
        for (int i = 0; i < size; i++) {
            String[] thisLine = scanner.nextLine().split("\\s+");
            for (int j = 0; j < size; j++) {
                squareArr[i][j] = thisLine[j];
            }
        }

        int firstDiagonalSum = 0;
        for (int i = 0; i < size; i++) {
            firstDiagonalSum += Integer.parseInt(squareArr[i][i]);
        }

        int secondDiagonalSum = 0;
        for (int i = size - 1; i >= 0; i--) {
            secondDiagonalSum += Integer.parseInt(squareArr[i][(size - 1) - i]);
        }

        System.out.println(
                Math.max(firstDiagonalSum,secondDiagonalSum) -
                Math.min(firstDiagonalSum,secondDiagonalSum));
    }
}
