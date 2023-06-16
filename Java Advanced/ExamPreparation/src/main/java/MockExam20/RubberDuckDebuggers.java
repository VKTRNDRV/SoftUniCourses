package MockExam20;

import java.util.*;

public class RubberDuckDebuggers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // reading input
        int[] line1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] line2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> allTimeValues = new ArrayDeque<>();
        ArrayDeque<Integer> allTaskNumberValues = new ArrayDeque<>();
        for(int t : line1){allTimeValues.add(t);}
        for(int m : line2){allTaskNumberValues.push(m);}

        // initialize duckies map
        Map<String, List<Integer>> duckiesInfo = new LinkedHashMap<>();
        duckiesInfo.put("Darth Vader Ducky", new ArrayList<>());
        duckiesInfo.get("Darth Vader Ducky").add(0);
        duckiesInfo.get("Darth Vader Ducky").add(60);
        duckiesInfo.get("Darth Vader Ducky").add(0);
        duckiesInfo.put("Thor Ducky", new ArrayList<>());
        duckiesInfo.get("Thor Ducky").add(61);
        duckiesInfo.get("Thor Ducky").add(120);
        duckiesInfo.get("Thor Ducky").add(0);
        duckiesInfo.put("Big Blue Rubber Ducky", new ArrayList<>());
        duckiesInfo.get("Big Blue Rubber Ducky").add(121);
        duckiesInfo.get("Big Blue Rubber Ducky").add(180);
        duckiesInfo.get("Big Blue Rubber Ducky").add(0);
        duckiesInfo.put("Small Yellow Rubber Ducky", new ArrayList<>());
        duckiesInfo.get("Small Yellow Rubber Ducky").add(181);
        duckiesInfo.get("Small Yellow Rubber Ducky").add(240);
        duckiesInfo.get("Small Yellow Rubber Ducky").add(0);

        // iterate until empty
        while (!allTimeValues.isEmpty() && !allTaskNumberValues.isEmpty()){
            int time = allTimeValues.poll();
            int tasks = allTaskNumberValues.pop();
            int product = time * tasks;

            // perform move as per product
            if(product >= 241){
                tasks -= 2;
                allTimeValues.add(time);
                allTaskNumberValues.push(tasks);

            }else {
                for (Map.Entry<String, List<Integer>> ducky : duckiesInfo.entrySet()){
                    int min = ducky.getValue().get(0);
                    int max = ducky.getValue().get(1);
                    int count = ducky.getValue().get(2);
                    if(product >= min && product <= max){
                        count++;
                        ducky.getValue().set(2, count);
                        break;
                    }
                }
            }
        }

        // print output
        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        for (Map.Entry<String, List<Integer>> ducky : duckiesInfo.entrySet()){
            System.out.printf("%s: %d\n"
                    , ducky.getKey(), ducky.getValue().get(2));
        }
    }
}
