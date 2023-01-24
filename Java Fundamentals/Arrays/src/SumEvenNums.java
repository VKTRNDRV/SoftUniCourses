import java.util.Scanner;

public class SumEvenNums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputsStr = scan.nextLine();
        String[] inputsTemp = inputsStr.split(" ");
        int[] inputsArr = new int[inputsTemp.length];
        for (int i = 0; i < inputsArr.length; i++){
            inputsArr[i] = Integer.parseInt(inputsTemp[i]);
        }

        int sumOfEvenNums = 0;
        for (int i = 0; i < inputsArr.length; i++) {
            if(inputsArr[i] % 2 == 0){
                sumOfEvenNums += inputsArr[i];
            }
        }
        System.out.println(sumOfEvenNums);
    }
}
