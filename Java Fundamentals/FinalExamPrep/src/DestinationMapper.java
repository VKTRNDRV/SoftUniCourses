import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        List<String> destinationsList = new ArrayList<>();

        Pattern destinationPattern = Pattern.compile("([=/])(?<destination>[A-Z][A-Za-z]{2,})(?=\\1)");
        Matcher matcher = destinationPattern.matcher(inputStr);
        while (matcher.find()){
            String destination = matcher.group("destination");
            destinationsList.add(destination);
        }

        int travelPoints = 0;
        for (String destination : destinationsList){
            travelPoints += destination.length();
        }

        System.out.print("Destinations: ");
        for (int i = 0; i < destinationsList.size(); i++) {
            String destination = destinationsList.get(i);
            if(i < destinationsList.size() - 1){
                System.out.print(destination + ", ");
            }else{
                System.out.print(destination);
            }
        }
        System.out.println();
        System.out.printf("Travel Points: %d", travelPoints);
    }
}
