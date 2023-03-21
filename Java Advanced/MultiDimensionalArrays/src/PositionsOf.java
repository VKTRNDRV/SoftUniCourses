import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
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

        boolean isFound = false;
        int testNum = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numsArr.length; i++) {
            for (int j = 0; j < numsArr[0].length; j++) {
                if(numsArr[i][j] == testNum){
                    isFound = true;
                    System.out.printf("%d %d%n", i, j);
                }
            }
        }

        if(!isFound){
            System.out.println("not found");
        }
    }
}
