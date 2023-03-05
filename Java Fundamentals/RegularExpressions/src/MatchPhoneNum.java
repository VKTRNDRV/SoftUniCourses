import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Pattern phoneNumPattern = Pattern.compile("[+]359([- ])2\\1\\d{3}\\1\\d{4}\\b");
        String phonesStr = scan.nextLine();
        Matcher phoneMatcher = phoneNumPattern.matcher(phonesStr);
        List<String> phonesList = new ArrayList<>();
        while (phoneMatcher.find()){
            phonesList.add(phoneMatcher.group());
        }

        System.out.print(String.join(", ", phonesList));
    }
}
