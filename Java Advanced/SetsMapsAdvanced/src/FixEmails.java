import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> emails = new LinkedHashMap<>();


        while (true){
            String name = scanner.nextLine();
            if(name.equals("stop")){break;}
            String email = scanner.nextLine();
            if(email.toLowerCase().endsWith("us") ||
                    email.toLowerCase().endsWith("uk") ||
                    email.toLowerCase().endsWith("com")){
            }else{
                emails.put(name, email);
            }
        }

        emails.entrySet()
                .forEach(e -> System.out.printf
                        ("%s -> %s%n", e.getKey(), e.getValue()));
    }
}
