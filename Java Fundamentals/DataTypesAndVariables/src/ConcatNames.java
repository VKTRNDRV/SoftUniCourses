import java.util.Scanner;

public class ConcatNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String firstName = new String(scan.nextLine());
        String secondName = new String(scan.nextLine());
        String delimiter = new String(scan.nextLine());

        String outputString = firstName + delimiter + secondName;

        System.out.println(outputString);
    }
}
