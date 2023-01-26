import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numOfRows = Integer.parseInt(scan.nextLine());
        int[] arr1 = new int[numOfRows];
        int[] arr2 = new int[numOfRows];
        int[] tempArr = new int[2];


        for (int currentRow = 1; currentRow <= numOfRows; currentRow++) {
            tempArr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();
            if(currentRow % 2 == 1){
                arr1[currentRow-1] = tempArr[0];
                arr2[currentRow-1] = tempArr[1];
            }else{
                arr1[currentRow-1] = tempArr[1];
                arr2[currentRow-1] = tempArr[0];
            }
        }
        for (int currentNum: arr1) {
            System.out.printf(currentNum + " ");
        }
        System.out.printf("%n");
        for (int currentNum: arr2) {
            System.out.printf(currentNum + " ");
        }
    }
}
