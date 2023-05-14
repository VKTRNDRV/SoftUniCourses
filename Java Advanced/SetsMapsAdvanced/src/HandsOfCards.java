import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> powerValues = new HashMap<>();
        powerValues.put("2", 2);powerValues.put("3", 3);
        powerValues.put("4", 4);powerValues.put("5", 5);powerValues.put("6", 6);
        powerValues.put("7", 7);powerValues.put("8", 8);powerValues.put("9", 9);
        powerValues.put("10", 10);powerValues.put("J", 11);powerValues.put("Q", 12);
        powerValues.put("K", 13);powerValues.put("A", 14);

        Map<String, Integer> typeMultipliers = new HashMap<>();
        typeMultipliers.put("S", 4);
        typeMultipliers.put("H", 3);
        typeMultipliers.put("D", 2);
        typeMultipliers.put("C", 1);

        Map<String, List<String>> players = new LinkedHashMap<>();

        while (true){
            String line = scanner.nextLine();
            if(line.equals("JOKER")){break;}
            String playerName = line.split(":")[0];
            line = line.replace(playerName + ":", " ");

            String[] cards = line.trim().split(", ");

            if(!players.containsKey(playerName)){
                players.put(playerName, new ArrayList<>());
            }
            for(String card : cards){
                if(!players.get(playerName).contains(card)){
                    players.get(playerName).add(card);
                }
            }
        }

        for(Map.Entry<String, List<String>> player : players.entrySet()){
            List<String> cards = player.getValue();
            int totalValue = 0;
            for(String card : cards){
                String power = card.substring(0, card.length() - 1);
                String type = String.valueOf(card.charAt(card.length() - 1));

                int cardValue = (typeMultipliers.get(type)) * (powerValues.get(power));
                totalValue += cardValue;
            }

            System.out.printf("%s: %d%n", player.getKey(), totalValue);
        }
    }
}
