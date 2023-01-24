import java.util.Arrays;
import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputsArr = scan.nextLine().split(" ");
        String tempString = "";

        for (int i = 0; i < (inputsArr.length/2); i++) {
            tempString = inputsArr[i];
            inputsArr[i] = inputsArr[inputsArr.length - (i+1)];
            inputsArr[inputsArr.length - (i+1)] = tempString;
        }
        for (int i = 0; i < (inputsArr.length); i++) {
            System.out.printf("%s ",inputsArr[i]);
        }
    }
}
