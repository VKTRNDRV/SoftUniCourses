import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] demonsArr = scan.nextLine().split("[, ]+");
        Pattern healthCharPattern = Pattern.compile("[^0-9-+*/.]");
        Pattern damageNumPattern = Pattern.compile("-?\\d+\\.?\\d*");
        for(String demonName : demonsArr){
            StringBuilder name = new StringBuilder();
            name.append(demonName);
            int health = 0;
            double damage = 0.0;

            //calculating health
            Matcher healthCharMatcher = healthCharPattern.matcher(name);
            while (healthCharMatcher.find()){
                char matchChar = name.charAt(healthCharMatcher.start());
                //name.replace(healthCharMatcher.start(), healthCharMatcher.start(),"");
                health += matchChar;
            }

            //summing damage
            Matcher damageNumMatcher = damageNumPattern.matcher(name);
            while (damageNumMatcher.find()){
                String thisDamageStr = name.substring(damageNumMatcher.start(), damageNumMatcher.end());
                //name.replace(damageNumMatcher.start(), damageNumMatcher.end(), "");
                damage += Double.parseDouble(thisDamageStr);
            }

            //multiplying/dividing damage
            for (int i = 0; i < name.length(); i++) {
                char thisChar = name.charAt(i);
                if(thisChar == '*'){
                    damage *= 2;
                }else if(thisChar == '/'){
                    damage /= 2;
                }
            }

            System.out.printf("%s - %d health, %.2f damage%n", demonName, health, damage);
        }
    }
}
