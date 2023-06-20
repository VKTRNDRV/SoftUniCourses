package Cards;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cardRank = sc.nextLine();
        String cardSuit = sc.nextLine();
        int cardPower = Rank.valueOf(cardRank).getValue()
                + Suit.valueOf(cardSuit).getValue();
        System.out.printf("Card name: %s of %s; Card power: %d"
                , cardRank, cardSuit, cardPower);
    }
}
