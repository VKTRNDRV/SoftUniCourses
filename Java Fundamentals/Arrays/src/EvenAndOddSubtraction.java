import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] inputs = Arrays.stream(scan.nextLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();

        int sum = 0;
        for (int i = 0; i < inputs.length; i++){
            if(inputs[i] % 2 == 0){
                sum += inputs[i];
            }else{
                sum -= inputs[i];
            }
        }
        System.out.println(sum);
    }
}
