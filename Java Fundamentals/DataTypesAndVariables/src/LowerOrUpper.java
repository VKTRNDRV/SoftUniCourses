import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char inputChar = scan.nextLine().charAt(0);
        int unicodeValue = (int) inputChar;

        if(unicodeValue >= 65 && unicodeValue <= 90){
            System.out.println("upper-case");
        }else if(unicodeValue >= 97 && unicodeValue <= 122){
            System.out.println("lower-case");
        }
    }
}
