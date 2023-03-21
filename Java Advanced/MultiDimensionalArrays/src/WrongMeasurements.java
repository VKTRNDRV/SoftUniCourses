import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int[][] numsArr = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int[] thisLine = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(value -> Integer.parseInt(value))
                    .toArray();
            numsArr[i] = new int[thisLine.length];
            for (int j = 0; j < thisLine.length; j++) {
                numsArr[i][j] = thisLine[j];
            }
        }

        int[] wrongValueIndexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(value -> Integer.parseInt(value))
                .toArray();
        int wrongValue = numsArr[wrongValueIndexes[0]][wrongValueIndexes[1]];

        //initializing new array
        int[][] arrNew = new int[rows][numsArr[0].length];

        //populating new array
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < numsArr[0].length; col++) {
                if(numsArr[row][col] == wrongValue){
                    int sumNew = 0;
                    //up
                    if(row >= 1){
                        if(numsArr[row-1][col] != wrongValue){
                            sumNew += numsArr[row-1][col];
                        }
                    }

                    //right
                    if(col < numsArr[0].length - 1){
                        if(numsArr[row][col+1] != wrongValue){
                            sumNew += numsArr[row][col+1];
                        }
                    }

                    //down
                    if(row < rows - 1){
                        if(numsArr[row+1][col] != wrongValue){
                            sumNew += numsArr[row+1][col];
                        }
                    }

                    //left
                    if(col >= 1){
                        if(numsArr[row][col-1] != wrongValue){
                            sumNew += numsArr[row][col-1];
                        }
                    }

                    arrNew[row][col] = sumNew;
                }else{
                    arrNew[row][col] = numsArr[row][col];
                }
            }
        }

        //printing newArr
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < arrNew[0].length; col++) {
                System.out.printf("%d ", arrNew[row][col]);
            }
            System.out.println();
        }
    }
}
