import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arrayInput = Arrays.stream(scan.nextLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();

        while(true){
            String[] currentCommandArr = scan.nextLine().split(" ");
            boolean isEnd = false;

            switch (currentCommandArr[0]) {
                case "swap" -> {
                    int temp = arrayInput[Integer.parseInt(currentCommandArr[1])];
                    arrayInput[Integer.parseInt(currentCommandArr[1])] = arrayInput[Integer.parseInt(currentCommandArr[2])];
                    arrayInput[Integer.parseInt(currentCommandArr[2])] = temp;
                }
                case "multiply" -> arrayInput[Integer.parseInt(currentCommandArr[1])] =
                        arrayInput[Integer.parseInt(currentCommandArr[1])] * arrayInput[Integer.parseInt(currentCommandArr[2])];
                case "decrease" -> {
                    for (int i = 0; i < arrayInput.length; i++) {
                        arrayInput[i]--;
                    }
                }
                case "end" -> isEnd = true;
            }
            if(isEnd){
                break;
            }
        }

        for (int i = 0; i < arrayInput.length; i++) {
            if (i != arrayInput.length - 1){
                System.out.printf("%d, ",arrayInput[i]);
            }else{
                System.out.printf("%d",arrayInput[i]);
            }
        }
    }
}
