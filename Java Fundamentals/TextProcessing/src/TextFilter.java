import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] bannedWordsArr = scan.nextLine().split(", ");
        String filterText = scan.nextLine();

        for(String thisBannedWord : bannedWordsArr){
            StringBuilder thisCensoredWord = new StringBuilder();
            thisCensoredWord.append("*".repeat(thisBannedWord.length()));
            while (filterText.contains(thisBannedWord)){
                filterText = filterText.replace(thisBannedWord, thisCensoredWord);
            }
        }
        System.out.println(filterText);
    }
}
