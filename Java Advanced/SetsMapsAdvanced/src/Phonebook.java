import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new LinkedHashMap<>();

        while (true){
            String input = scanner.nextLine();
            if(input.equals("search")){break;}
            String name = input.split("-")[0];
            String phoneNumber = input.split("-")[1];
            phonebook.put(name, phoneNumber);
        }

        while (true){
            String input = scanner.nextLine();
            if(input.equals("stop")){break;}

            if (phonebook.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
        }
    }
}
