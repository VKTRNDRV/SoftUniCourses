package FinalExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TempleOfDoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // reading input
        int[] line1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] line2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> allTools = new ArrayDeque<>();
        ArrayDeque<Integer> allSubstances = new ArrayDeque<>();
        for(int t : line1){allTools.add(t);}
        for(int s : line2){allSubstances.push(s);}

        List<Integer> allChallenges = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // iterating until no challenges
        while (!allChallenges.isEmpty()){
            int tool = allTools.poll();
            int substance = allSubstances.pop();
            int product = tool * substance;

            // check all challenges
            boolean isChallengeRemoved = false;
            for (int i = allChallenges.size() - 1; i >= 0; i--) {
                int challenge = allChallenges.get(i);
                if(product == challenge){
                    allChallenges.remove(i);
                    isChallengeRemoved = true;
                    break;
                }
            }

            // update and return task and substance IF no challenge removed
            if(!isChallengeRemoved){
                tool++;
                allTools.add(tool);
                substance--;
                if(substance > 0) {
                    allSubstances.push(substance);
                }
            }

            // break if no tools/substance
            if(allTools.isEmpty() || allSubstances.isEmpty()){
                break;
            }
        }

        //printing output
        if(allChallenges.isEmpty()){
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        }else {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        }
        if(!allTools.isEmpty()){
            System.out.print("Tools: ");
            while (allTools.size() > 1){
                System.out.printf("%d, ", allTools.poll());
            }
            System.out.println(allTools.poll());
        }
        if(!allSubstances.isEmpty()){
            System.out.print("Substances: ");
            while (allSubstances.size() > 1){
                System.out.printf("%d, ", allSubstances.pop());
            }
            System.out.println(allSubstances.pop());
        }
        if(!allChallenges.isEmpty()){
            System.out.print("Challenges: ");
            for (int i = 0; i < allChallenges.size() - 1; i++) {
                System.out.printf("%d, ", allChallenges.get(i));
            }
            System.out.print(allChallenges.get(allChallenges.size() - 1));
        }
    }
}
