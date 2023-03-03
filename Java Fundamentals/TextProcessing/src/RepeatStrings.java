import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] stringsArr = scan.nextLine().split(" ");
        for(String thisString : stringsArr){
            for (int i = 1; i <= thisString.length(); i++) {
                System.out.printf("%s", thisString);
            }
        }
    }
}
