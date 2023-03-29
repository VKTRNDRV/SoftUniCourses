import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfLines = Integer.parseInt(scanner.nextLine());
        Pattern namePattern = Pattern.compile("@(?<name>\\w+)[|]");
        Pattern agePattern = Pattern.compile("#(?<age>\\d+)[*]");
        for (int i = 0; i < numOfLines; i++) {
            String inputLine = scanner.nextLine();
            Matcher nameMatcher = namePattern.matcher(inputLine);
            Matcher ageMatcher = agePattern.matcher(inputLine);
            if(nameMatcher.find() && ageMatcher.find()){
                String name = nameMatcher.group("name");
                String age = ageMatcher.group("age");
                System.out.printf("%s is %s years old.%n", name, age);
            }
        }
    }
}
