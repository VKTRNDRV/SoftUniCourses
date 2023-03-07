import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String namesStr = scan.nextLine();

        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]+ [A-Z][a-z]+\\b");
        Matcher matcher = pattern.matcher(namesStr);
        while (matcher.find()){
            System.out.print(matcher.group() + " ");
        }
    }
}