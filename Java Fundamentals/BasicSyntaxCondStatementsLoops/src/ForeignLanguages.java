import java.util.Scanner;

public class ForeignLanguages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        switch (input){
            case "England":
            case "USA": System.out.printf("English"); break;

            case "Spain":
            case "Argentina":
            case "Mexico": System.out.printf("Spanish"); break;

            default: System.out.printf("unknown"); break;
        }
    }
}
