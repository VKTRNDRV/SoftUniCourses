import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = Arrays.stream(scan.nextLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();

        for (int i = (array.length - 1); i > 0; i--) {
            for (int j = 0; j < (array.length - 1); j++) {
                array[j] += array[j+1];
            }
        }
        System.out.println(array[0]);
    }
}
