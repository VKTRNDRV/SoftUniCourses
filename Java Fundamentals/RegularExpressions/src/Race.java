import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, Integer> racersDistanceMap = new LinkedHashMap<>();
        String[] racers = scan.nextLine().split(", ");
        for(String racer : racers){racersDistanceMap.put(racer, 0);}

        Pattern removeCharPattern = Pattern.compile("\\W");
        Pattern digitPattern = Pattern.compile("\\d");
        while (true){
            StringBuilder line = new StringBuilder();
            line.append(scan.nextLine());
            if(line.toString().equals("end of race")){break;}

            Matcher removeCharMatcher = removeCharPattern.matcher(line);
            Matcher digitMatcher = digitPattern.matcher(line);
            int distanceSum = 0;
            while (removeCharMatcher.find()){
                line.replace(removeCharMatcher.start(), removeCharMatcher.start(), "");
            }

            while (digitMatcher.find()){
                distanceSum += Integer.parseInt(digitMatcher.group());
                line.replace(digitMatcher.start(), digitMatcher.start(), "");
            }

            if(racersDistanceMap.containsKey(line.toString())){
                racersDistanceMap.put(line.toString(), racersDistanceMap.get(line.toString()) + distanceSum);
            }
        }

        List<Map.Entry<String, Integer>> sortList = new ArrayList<>(racersDistanceMap.entrySet());
        sortList.sort(Comparator.comparing(Map.Entry::getValue));
        for (int i = 1; i <= 3; i++) {
            Map.Entry<String, Integer> thisRacer = sortList.get(i-1);
            String name = thisRacer.getKey();
            switch (String.valueOf(i)){
                case "1": System.out.printf("1st place: %s%n", name);break;

                case "2": System.out.printf("2nd place: %s%n", name);break;

                case "3": System.out.printf("3rd place: %s%n", name);break;
            }
        }
    }
}
