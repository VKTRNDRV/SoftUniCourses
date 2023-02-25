import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputsCount = Integer.parseInt(scan.nextLine());
        LinkedHashMap<String, ArrayList<String>> synonymsMap = new LinkedHashMap<>();
        for(int i = 1; i <= inputsCount; i++){
            String word = scan.nextLine();
            String synonym = scan.nextLine();
            synonymsMap.putIfAbsent(word, new ArrayList<>());
            synonymsMap.get(word).add(synonym);
        }

        for(Map.Entry<String, ArrayList<String>> currentEntry : synonymsMap.entrySet()){
            System.out.printf("%s - ", currentEntry.getKey());
            ArrayList<String> currentList = currentEntry.getValue();

            for (int i = 0; i < currentList.size(); i++) {
                String currentSynonym = currentList.get(i);
                if(i < currentList.size() - 1){
                    System.out.printf("%s, ",currentList.get(i));
                }else{
                    System.out.printf("%s%n",currentList.get(i));
                }
            }
        }
    }
}
