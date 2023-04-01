import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();

        List<Integer> numsList = new ArrayList<>();
        Pattern digitPattern = Pattern.compile("\\d{1}");
        Matcher digitMatcher = digitPattern.matcher(inputText);
        while (digitMatcher.find()){
            numsList.add(Integer.parseInt(digitMatcher.group()));
        }

        BigInteger threshold = new BigInteger("1");
        for(int num : numsList){
            threshold = threshold.multiply(BigInteger.valueOf(num));
        }

        List<String> emojisList = new ArrayList<>();
        Pattern emojiPattern = Pattern.compile("(?<wrapper>[:]{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})\\1");
        Matcher emojiMatcher = emojiPattern.matcher(inputText);
        int emojiCount = 0;
        while (emojiMatcher.find()){
            String emoji = emojiMatcher.group();
            emojisList.add(emoji);
            emojiCount++;
        }

        System.out.printf("Cool threshold: %s%n", threshold.toString());
        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojiCount);
        for(String emoji : emojisList){
            boolean isCool = false;
            int emojiCoolness = 0;
            for (int i = 2; i < emoji.length() - 2; i++) {
                char thisChar = emoji.charAt(i);
                emojiCoolness += thisChar;
            }

            BigInteger tempBI = threshold.subtract(BigInteger.valueOf(emojiCoolness));
            if(tempBI.compareTo(BigInteger.ZERO) <= 0){
                isCool = true;
            }
            if(isCool){
                System.out.println(emoji);
            }
        }
    }
}
