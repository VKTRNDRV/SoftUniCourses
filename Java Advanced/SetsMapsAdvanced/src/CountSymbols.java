import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Map<Character, Integer> chars = new LinkedHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if(!chars.containsKey(ch)){
                chars.put(ch, 1);
            }else{
                chars.put(ch, chars.get(ch) + 1);
            }
        }

        chars.entrySet().stream()
                .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .forEach(e -> System.out.printf("%c: %d time/s%n", e.getKey(), e.getValue()));
    }
}
