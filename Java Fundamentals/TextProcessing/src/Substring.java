import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String delString = scan.nextLine();
        String fullString = scan.nextLine();
        while (fullString.indexOf(delString) != -1){
            fullString = fullString.replace(delString, "");
        }
        System.out.println(fullString);
    }
}
