import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //reading and writing first array
        int[] firstArraySizes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(value -> Integer.parseInt(value))
                .toArray();
        int[][] firstArray = new int[firstArraySizes[0]][firstArraySizes[1]];
        for (int i = 0; i < firstArraySizes[0]; i++) {
            int[] thisLine = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(value -> Integer.parseInt(value))
                    .toArray();
            for (int j = 0; j < firstArraySizes[1]; j++) {
                firstArray[i][j] = thisLine[j];
            }
        }

        //reading and writing second array
        int[] secondArraySizes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(value -> Integer.parseInt(value))
                .toArray();
        int[][] secondArray = new int[secondArraySizes[0]][secondArraySizes[1]];
        for (int i = 0; i < secondArraySizes[0]; i++) {
            int[] thisLine = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(value -> Integer.parseInt(value))
                    .toArray();
            for (int j = 0; j < secondArraySizes[1]; j++) {
                secondArray[i][j] = thisLine[j];
            }
        }

        if(areArraysEqual(firstArray, secondArray)){
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }
    }

    public static boolean areArraysEqual(int[][] firstArray, int[][] secondArray){
        if(firstArray.length != secondArray.length || firstArray[0].length != secondArray[0].length){
            return false;
        }

        for (int i = 0; i < firstArray.length; i++) {
            for (int j = 0; j < firstArray[0].length; j++) {
                if(firstArray[i][j] != secondArray[i][j]){
                    return false;
                }
            }
        }

        return true;
    }
}