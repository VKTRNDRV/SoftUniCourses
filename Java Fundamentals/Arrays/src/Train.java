import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] wagonsArr = new int[Integer.parseInt(scan.nextLine())];
        int totalPassengers = 0;

        for (int i = 0; i < wagonsArr.length; i++) {
            wagonsArr[i] = Integer.parseInt(scan.nextLine());
            totalPassengers += wagonsArr[i];
            System.out.printf("%d ",wagonsArr[i]);
        }
        System.out.printf("%n%d",totalPassengers);
    }
}
