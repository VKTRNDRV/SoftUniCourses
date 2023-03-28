import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        Pattern wordPattern = Pattern.compile("(?<delimiter>[@#])(?<firstWord>[A-Za-z]{3,})\\1\\1(?<secondWord>[A-Za-z]{3,})\\1");
        Matcher wordMatcher = wordPattern.matcher(inputString);
        List<String> pairsList = new ArrayList<>();
        while (wordMatcher.find()){
            pairsList.add(wordMatcher.group("firstWord"));
            pairsList.add(wordMatcher.group("secondWord"));
        }

        List<String> mirrorWordsList = new ArrayList<>();
        for (int i = 0; i < pairsList.size() - 1; i+=2) {
            StringBuilder firstWord = new StringBuilder(pairsList.get(i));
            StringBuilder secondWord = new StringBuilder(pairsList.get(i+1));
            if((firstWord.toString()).equals(secondWord.reverse().toString())){
                String element = firstWord + " <=> " + secondWord.reverse();
                mirrorWordsList.add(element);
            }
        }

        if(pairsList.size() != 0){
            System.out.printf("%d word pairs found!%n", pairsList.size()/2);
            if(mirrorWordsList.size() != 0){
                System.out.println("The mirror words are:");
                System.out.println(String.join(", ", mirrorWordsList));
            }else{
                System.out.println("No mirror words!");
            }

        }else{
            System.out.println("No word pairs found!");
            System.out.println("No mirror words!");
        }
    }
}
