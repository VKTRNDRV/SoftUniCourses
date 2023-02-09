import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> deck1 = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> deck2 = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (deck1.size() != 0 && deck2.size() != 0) {
            int deck1FirstCard = deck1.get(0);
            int deck2FirstCard = deck2.get(0);

            if (deck1FirstCard > deck2FirstCard) {
                moveCards(deck1, deck2);

            } else if (deck1FirstCard == deck2FirstCard) {
                deck1.remove(0);
                deck2.remove(0);

            } else if (deck1FirstCard < deck2FirstCard) {
                moveCards(deck2, deck1);
            }
        }

        int sum = 0;
        if(deck1.size() != 0){
            sum = getSum(deck1);
            System.out.printf("First player wins! Sum: %d", sum);

        }else{
            sum = getSum(deck2);
            System.out.printf("Second player wins! Sum: %d", sum);
        }
    }

    public static void moveCards(List<Integer> winDeck, List<Integer> loseDeck){
        int firstCardWinDeck = winDeck.get(0);
        int firstCardLoseDeck = loseDeck.get(0);

        winDeck.remove(0);
        loseDeck.remove(0);

        winDeck.add(firstCardWinDeck);
        winDeck.add(firstCardLoseDeck);
    }

    public static int getSum(List<Integer> list){
        int sum = 0;
        for(int currentNum : list){
            sum += currentNum;
        }

        return sum;
    }
}
