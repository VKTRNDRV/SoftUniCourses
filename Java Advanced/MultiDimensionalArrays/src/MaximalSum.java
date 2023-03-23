import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(value -> Integer.parseInt(value))
                .toArray();
        int[][] numsArr = new int[dimensions[0]][dimensions[1]];
        for (int i = 0; i < dimensions[0]; i++) {
            int[] thisLine = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(value -> Integer.parseInt(value))
                    .toArray();
            for (int j = 0; j < dimensions[1]; j++) {
                numsArr[i][j] = thisLine[j];
            }
        }

        int maxSum = 0;
        int subRow = 0;
        int subCol = 0;

        for (int row = 0; row < numsArr.length - 2; row++) {
            for (int col = 0; col < numsArr[0].length - 2; col++) {
                int thisSum = numsArr[row][col]
                        + numsArr[row][col+1]
                        + numsArr[row][col+2]
                        + numsArr[row+1][col]
                        + numsArr[row+1][col+1]
                        + numsArr[row+1][col+2]
                        + numsArr[row+2][col]
                        + numsArr[row+2][col+1]
                        + numsArr[row+2][col+2];
                if(thisSum > maxSum){
                    maxSum = thisSum;
                    subRow = row;
                    subCol = col;
                }
            }
        }

        System.out.printf("Sum = %d%n", maxSum);
        for (int row = subRow; row < subRow + 3; row++) {
            for (int col = subCol; col < subCol + 3; col++) {
                System.out.printf("%d ", numsArr[row][col]);
            }
            System.out.println();
        }
    }
}
