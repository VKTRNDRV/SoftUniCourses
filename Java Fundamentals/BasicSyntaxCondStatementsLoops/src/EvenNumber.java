import java.nio.file.LinkPermission;
import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int num = Integer.parseInt(input);

        while (num % 2 != 0) {
            System.out.println("Please write an even number.");
            num = Integer.parseInt(scan.nextLine());
        }

        System.out.printf("The number is: %d", Math.abs(num));
    }
}
