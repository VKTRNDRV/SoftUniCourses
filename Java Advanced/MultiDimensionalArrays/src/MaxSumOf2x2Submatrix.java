import java.util.Arrays;
import java.util.Scanner;

public class MaxSumOf2x2Submatrix {
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
        int maxSum = 0;
        int subRow = 0;
        int subCol = 0;
        for (int row = 0; row < dimensions[0] - 1; row++) {
            for (int col = 0; col < dimensions[1] - 1; col++) {
                int thisSum = numsArr[row][col]
                        + numsArr[row+1][col]
                        + numsArr[row][col+1]
                        + numsArr[row+1][col+1];
                if(thisSum > maxSum){
                    maxSum = thisSum;
                    subRow = row;
                    subCol = col;
                }
            }
        }

        System.out.printf("%d %d%n", numsArr[subRow][subCol], numsArr[subRow][subCol + 1]);
        System.out.printf("%d %d%n", numsArr[subRow + 1][subCol], numsArr[subRow + 1][subCol + 1]);
        System.out.println(maxSum);
    }
}
