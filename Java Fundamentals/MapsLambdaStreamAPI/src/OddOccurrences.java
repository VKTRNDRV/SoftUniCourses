import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] allWordsArr = scan.nextLine().split(" ");
        LinkedHashMap<String, Integer> wordsCount = new LinkedHashMap<>();
        for(String currentWord : allWordsArr){
            String currWordLowCase = currentWord.toLowerCase();
            if(wordsCount.containsKey(currWordLowCase)){
                wordsCount.put(currWordLowCase, wordsCount.get(currWordLowCase) + 1);
            }else{
                wordsCount.put(currWordLowCase, 1);
            }
        }

        ArrayList<String> oddsList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : wordsCount.entrySet()){
            if(entry.getValue() % 2 == 1){
                oddsList.add(entry.getKey());
            }
        }

        for (int i = 0; i < oddsList.size(); i++) {
            String thisWord = oddsList.get(i);
            if(i != oddsList.size() - 1){
                System.out.printf("%s, ", thisWord);
            }else{
                System.out.print(thisWord);
            }
        }
    }
}
