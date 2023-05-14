import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> usernames = new LinkedHashSet<String>();
        int inputCount = Integer.parseInt(scanner.nextLine());
        while (inputCount > 0){
            String input = scanner.nextLine();
            if(!usernames.contains(input)){
                usernames.add(input);
            }
            inputCount--;
        }

        usernames.forEach(s -> System.out.println(s));
    }
}
