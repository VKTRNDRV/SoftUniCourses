import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr1 = Arrays.stream(scan.nextLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();
        int[] arr2 = Arrays.stream(scan.nextLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();

        int sumArr1 = 0;
        boolean isIdentical = true;
        int wrongIndex = 0;
        for (int i = 0; i < arr1.length; i++) {

            if(arr1[i] == arr2[i]){
                sumArr1 += arr1[i];
            }else{
                isIdentical = false;
                wrongIndex = i;
                break;
            }
        }
        if(isIdentical){
            System.out.printf("Arrays are identical. Sum: %d", sumArr1);
        }else{
            System.out.printf("Arrays are not identical. Found difference at %d index.", wrongIndex);
        }
    }
}
