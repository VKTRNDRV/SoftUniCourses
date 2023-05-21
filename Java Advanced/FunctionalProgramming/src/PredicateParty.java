import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        BiPredicate<String, String> startsWith = String::startsWith;
        BiPredicate<String, String> endsWith = String::endsWith;
        BiPredicate<String, Integer> isLength = (str, num) -> {return str.length() == num;};

        while (true){
            String[] command = scanner.nextLine().split("\\s+");
            if(command[0].equals("Party!")){
                break;
            }

            switch (command[0]){
                case "Remove":
                    switch (command[1]){
                        case "StartsWith":
                            String startStr = command[2];
                            for (int i = 0; i < guests.size(); i++) {
                                String name = guests.get(i);
                                if(startsWith.test(name, startStr)){
                                    guests.remove(i);
                                    i--;
                                }
                            }
                            break;

                        case "EndsWith":
                            String endStr = command[2];
                            for (int i = 0; i < guests.size(); i++) {
                                String name = guests.get(i);
                                if(endsWith.test(name, endStr)){
                                    guests.remove(i);
                                    i--;
                                }
                            }
                            break;

                        case "Length":
                            int testLength = Integer.parseInt(command[2]);
                            for (int i = 0; i < guests.size(); i++) {
                                String name = guests.get(i);
                                if(isLength.test(name, testLength)){
                                    guests.remove(i);
                                    i--;
                                }
                            }
                            break;
                    }
                    break;

                case "Double":
                    switch (command[1]){
                        case "StartsWith":
                            String startStr = command[2];
                            for (int i = 0; i < guests.size(); i++) {
                                String guest = guests.get(i);
                                if(startsWith.test(guest, startStr)){
                                    guests.add(i + 1, guest);
                                    i++;
                                }
                            }
                            break;

                        case "EndsWith":
                            String endStr = command[2];
                            for (int i = 0; i < guests.size(); i++) {
                                String guest = guests.get(i);
                                if(endsWith.test(guest, endStr)){
                                    guests.add(i + 1, guest);
                                    i++;
                                }
                            }
                            break;

                        case "Length":
                            int testLength = Integer.parseInt(command[2]);
                            for (int i = 0; i < guests.size(); i++) {
                                String guest = guests.get(i);
                                if(isLength.test(guest, testLength)){
                                    guests.add(i + 1, guest);
                                    i++;
                                }
                            }
                            break;
                    }
                    break;
            }
        }

        if(guests.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else{
            guests.sort((name1, name2) -> name1.compareTo(name2));
            for (int i = 0; i < guests.size(); i++) {
                if(i < guests.size() - 1){
                    System.out.printf("%s, ", guests.get(i));

                }else{
                    System.out.printf("%s are going to the party!", guests.get(i));
                }
            }
        }
    }
}
