package MockExam12;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // reading input
        int[] line1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] line2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> allMales = new ArrayDeque<>();
        ArrayDeque<Integer> allFemales = new ArrayDeque<>();
        for(int m : line1){allMales.push(m);}
        for(int f : line2){allFemales.add(f);}
        int matchesCount = 0;

        // iterating until empty
        while (!allMales.isEmpty() && !allFemales.isEmpty()){
            int male = allMales.pop();
            int female = allFemales.poll();

            // checking for zero/negatives
            if(male <= 0){
                allFemales.push(female);
                continue;
            }
            if(female <= 0){
                allMales.push(male);
                continue;
            }

            // checking for %25
            if(male % 25 == 0){
                if(!allMales.isEmpty()) {
                    allMales.pop();
                }
                allFemales.push(female);
                continue;
            }
            if(female % 25 == 0){
                if(!allFemales.isEmpty()) {
                    allFemales.poll();
                }
                allMales.push(male);
                continue;
            }

            // checking for match
            if(male == female){
                matchesCount++;

            } else {
                male -= 2;
                allMales.push(male);
            }
        }

        // printing output
        System.out.printf("Matches: %d\n", matchesCount);

        System.out.print("Males left: ");
        if(allMales.isEmpty()){
            System.out.println("none");
        }else{
            while (allMales.size() > 1){
                System.out.printf("%d, ", allMales.pop());
            }
            System.out.println(allMales.pop());
        }

        System.out.print("Females left: ");
        if(allFemales.isEmpty()){
            System.out.println("none");
        }else{
            while (allFemales.size() > 1){
                System.out.printf("%d, ", allFemales.poll());
            }
            System.out.print(allFemales.poll());
        }
    }
}
