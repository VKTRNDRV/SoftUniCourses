import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();
        Pattern emailPattern = Pattern.compile
                ("(?<user>\\w+[\\w-.]*\\w+)@(?<hostFirst>[A-Za-z-.]+[.]+)(?<hostSecond>[A-Za-z]+)");
        Matcher emailMatcher = emailPattern.matcher(text);
        while (emailMatcher.find()){
            String email = emailMatcher.group();
            System.out.println(email);
        }
    }
}
