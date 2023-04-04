import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> regularGuests = new TreeSet<>();
        TreeSet<String> vipGuests = new TreeSet<>();

        //adding guests
        while (true){
            String guest = scanner.nextLine();
            if(guest.equals("PARTY")){break;}
            if(Character.isDigit(guest.charAt(0))){// VIP guest
                vipGuests.add(guest);
            }else{
                regularGuests.add(guest);
            }
        }

        //removing guests that have arrived
        while (true){
            String guest = scanner.nextLine();
            if(guest.equals("END")){break;}
            if(Character.isDigit(guest.charAt(0))){// VIP guest
                vipGuests.remove(guest);
            }else{
                regularGuests.remove(guest);
            }
        }

        //printing missing guests
        System.out.println(vipGuests.size() + regularGuests.size());
        vipGuests.forEach(s -> System.out.println(s));
        regularGuests.forEach(s -> System.out.println(s));
    }
}
