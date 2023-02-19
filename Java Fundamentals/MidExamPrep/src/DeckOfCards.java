import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DeckOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> cardsList = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toList());
        int totalCommands = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= totalCommands; i++) {
            String[] currentCommand = scan.nextLine().split(", ");

            switch (currentCommand[0]){
                case "Add":
                    String addName = currentCommand[1];
                    if(!cardsList.contains(addName)){
                        cardsList.add(addName);
                        System.out.println("Card successfully added");

                    }else{
                        System.out.println("Card is already in the deck");
                    }
                    break;

                case "Remove":
                    String removeName = currentCommand[1];
                    if(cardsList.contains(removeName)){
                        cardsList.remove(removeName);
                        System.out.println("Card successfully removed");

                    }else{
                        System.out.println("Card not found");
                    }
                    break;

                case "Remove At":
                    int removeAtIndex = Integer.parseInt(currentCommand[1]);
                    if(removeAtIndex >= 0 && removeAtIndex < cardsList.size()){
                        cardsList.remove(removeAtIndex);
                        System.out.println("Card successfully removed");

                    }else{
                        System.out.println("Index out of range");
                    }
                    break;

                case "Insert":
                    int insertIndex = Integer.parseInt(currentCommand[1]);
                    String insertName = currentCommand[2];
                    if(insertIndex >= 0 && insertIndex < cardsList.size()){
                        if(!cardsList.contains(insertName)){
                            cardsList.add(insertIndex, insertName);
                            System.out.println("Card successfully added");

                        }else{
                            System.out.println("Card is already added");
                        }
                    }else{
                        System.out.println("Index out of range");
                    }
                    break;
            }
        }

        System.out.printf(String.join(", ", cardsList));
    }
}
