import java.util.Scanner;

public class PrintNumsInReverseOrder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputItemsCount = Integer.parseInt(scan.nextLine());
        int[] inputs = new int[inputItemsCount];

        for(int i = 0; i < inputs.length; i++) {
            inputs[i] = Integer.parseInt(scan.nextLine());
        }
        for (int i = inputs.length - 1; i >= 0; i--){
            System.out.printf("%d ",inputs[i]);
        }
    }
}
