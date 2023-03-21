import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(value -> Integer.parseInt(value))
                .toArray();

        int[][] numsArr = new int[dimensions[0]][dimensions[1]];
        for (int i = 0; i < dimensions[0]; i++) {
            int[] thisLine = Arrays.stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(value -> Integer.parseInt(value))
                    .toArray();
            for (int j = 0; j < dimensions[1]; j++) {
                numsArr[i][j] = thisLine[j];
            }
        }
        int totalSum = 0;
        for (int row = 0; row < dimensions[0]; row++) {
            for (int col = 0; col < dimensions[1]; col++) {
                totalSum += numsArr[row][col];
            }
        }

        System.out.println(dimensions[0]);
        System.out.println(dimensions[1]);
        System.out.println(totalSum);
    }
}
