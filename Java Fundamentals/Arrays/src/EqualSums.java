import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = Arrays.stream(scan.nextLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();

        boolean isFound = false;
        int index = 0;
        for (int currEl = 0; currEl < array.length; currEl++){
             int leftSum = 0;
             int rightSum = 0;
            for (int l = 0; l < array.length; l++) {
                if(l < currEl){
                    leftSum += array[l];
                } else if (l == currEl) {
                    //do nothing
                }else if (l > currEl){
                    rightSum += array[l];
                }
            }
            if(leftSum == rightSum){
                isFound = true;
                index = currEl;
                break;
            }
        }
        if(isFound){
            System.out.println(index);
        }else{
            System.out.printf("no");
        }
    }
}
