import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BossRush {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputsCount = Integer.parseInt(scanner.nextLine());
        Pattern validInputPattern = Pattern
                .compile("\\|(?<bossName>[A-Z]{4,})\\|\\:\\#(?<bossTitle>[A-Za-z]+\\s[A-Za-z]+)\\#");
        for (int i = 0; i < inputsCount; i++) {
            String inputLine = scanner.nextLine();
            Matcher validMatcher = validInputPattern.matcher(inputLine);
            if(validMatcher.find()){
                String bossName = validMatcher.group("bossName");
                String bossTitle = validMatcher.group("bossTitle");
                System.out.printf("%s, The %s%n", bossName, bossTitle);
                System.out.printf(">> Strength: %d%n", bossName.length());
                System.out.printf(">> Armor: %d%n", bossTitle.length());

            }else{
                System.out.println("Access denied!");
            }
        }
    }
}
