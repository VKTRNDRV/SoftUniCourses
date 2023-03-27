import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder locationsStr =  new StringBuilder(scanner.nextLine());

        while (true){
            String[] commandArr = scanner.nextLine().split(":");
            if(commandArr[0].equals("Travel")){break;}
            String command = commandArr[0];
            switch (command){
                case "Add Stop":
                    int addIndex = Integer.parseInt(commandArr[1]);
                    String addStr = commandArr[2];
                    if(addIndex >= 0 && addIndex < locationsStr.length()){
                        locationsStr.insert(addIndex, addStr);
                    }
                    break;

                case "Remove Stop":
                    int removeStartIndex = Math.min(Integer.parseInt(commandArr[1]), Integer.parseInt(commandArr[2]));
                    int removeEndIndex = Math.max(Integer.parseInt(commandArr[1]), Integer.parseInt(commandArr[2]));
                    if((removeStartIndex >= 0 && removeStartIndex < locationsStr.length())
                    && (removeEndIndex >= 0 && removeEndIndex < locationsStr.length())){
                        locationsStr.delete(removeStartIndex, removeEndIndex + 1);
                    }
                    break;

                case "Switch":
                    Pattern oldStrPattern = Pattern.compile(commandArr[1]);
                    Matcher oldStrMatcher = oldStrPattern.matcher(locationsStr);
                    String stringNew = commandArr[2];
                    if(oldStrMatcher.find()){
                        locationsStr.replace(oldStrMatcher.start(), oldStrMatcher.end(), stringNew);
                    }

                    break;
            }

            System.out.println(locationsStr);
        }

        System.out.println("Ready for world tour! Planned stops: " + locationsStr);
    }
}
