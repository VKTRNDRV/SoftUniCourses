import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();
        Scanner textScanner = new Scanner(inputText);
        List<String> uppercaseWords = new ArrayList<>();
        Predicate<String> isUppercase = s -> Character.isUpperCase(s.charAt(0));
        while (textScanner.hasNext()){
            String word = textScanner.next();
            if(isUppercase.test(word)){
                uppercaseWords.add(word);
            }
        }

        System.out.println(uppercaseWords.size());
        uppercaseWords.forEach(s -> System.out.println(s));
    }
}
