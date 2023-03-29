import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] StringsArr = scanner.nextLine().split("\\s+");
        BigDecimal totalSum = BigDecimal.valueOf(0);
        Pattern templatePattern = Pattern
                .compile("(?<firstChar>[A-Za-z]{1})(?<number>\\d+)(?<secondChar>[A-Za-z]{1})");
        for(String string : StringsArr){
            Matcher templateMatcher = templatePattern.matcher(string);
            if(templateMatcher.find()) {
                char firstChar = templateMatcher.group("firstChar").charAt(0);
                int number = Integer.parseInt(templateMatcher.group("number"));
                char secondChar = templateMatcher.group("secondChar").charAt(0);
                totalSum = totalSum.add(BigDecimal.valueOf(getResult(firstChar, number, secondChar)));
            }
        }

        System.out.printf("%.2f", totalSum);
    }

    public static double getResult(char firstChar, int number, char secondChar){
        double doubleNum = number;
        if(firstChar >= 65 && firstChar <= 90){//firstChar is uppercase
            doubleNum /= (firstChar - 64);

        }else if (firstChar >= 97 && firstChar <= 122){//firstChar is lowercase
            doubleNum *= (firstChar - 96);
        }

        if(secondChar >= 65 && secondChar <= 90){//secondChar is uppercase
            doubleNum -= (secondChar - 64);

        }else if (secondChar >= 97 && secondChar <= 122){//secondChar is lowercase
            doubleNum += (secondChar - 96);
        }

        return doubleNum;
    }
}
