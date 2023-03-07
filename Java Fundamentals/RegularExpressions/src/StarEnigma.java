import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> attackedPlanets = new ArrayList<>();
        ArrayList<String> destroyedPlanets = new ArrayList<>();
        Pattern pattern = Pattern.compile
                ("(?<planetName>@[A-Za-z]+)[^-@!:>]*(?<population>:\\d+)[^-@!:>]*(?<attackType>![AD]!)[^-@!:>]*(?<soldierCount>->\\d+)");

        int numOfLines = Integer.parseInt(scan.nextLine());
        for(int i = 1; i <= numOfLines; i++){
            StringBuilder line = new StringBuilder();
            line.append(scan.nextLine());

            //calculating encryptKey
            int encryptKey = 0;
            for (int j = 0; j < line.length(); j++) {
                char thisChar = line.charAt(j);
                switch (thisChar){
                    case 'S':
                    case 's':
                    case 'T':
                    case 't':
                    case 'A':
                    case 'a':
                    case 'R':
                    case 'r':
                        encryptKey++;
                        break;
                }
            }

            //decrypting line
            for (int j = 0; j < line.length(); j++) {
                char thisChar = line.charAt(j);
                char thisNewChar = (char) (thisChar - encryptKey);
                line.setCharAt(j, thisNewChar);
            }

            //adding planets to lists if valid
            Matcher patternMatcher = pattern.matcher(line.toString());
            if(patternMatcher.find()){
                String planetName = patternMatcher.group("planetName");
                planetName = planetName.substring(1);
                String attackType = patternMatcher.group("attackType");
                attackType = attackType.substring(1, attackType.length() - 1);
                switch (attackType){
                    case "A":
                        attackedPlanets.add(planetName);
                        break;
                    case "D":
                        destroyedPlanets.add(planetName);
                        break;
                }
            }
        }

        System.out.printf("Attacked planets: %d%n", attackedPlanets.size());
        for(int i = attackedPlanets.size() - 1; i >= 0; i--){
            String planet = attackedPlanets.get(i);
            System.out.printf("-> %s%n", planet);
        }

        System.out.printf("Destroyed planets: %d%n", destroyedPlanets.size());
        for(int i = destroyedPlanets.size() - 1; i >= 0; i--){
            String planet = destroyedPlanets.get(i);
            System.out.printf("-> %s%n", planet);
        }
    }
}
