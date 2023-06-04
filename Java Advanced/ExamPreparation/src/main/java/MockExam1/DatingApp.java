package MockExam1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] malesInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();

        int[] femalesInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();

        ArrayDeque<Integer> males = new ArrayDeque<>();
        ArrayDeque<Integer> females = new ArrayDeque<>();

        for (int male : malesInput) {males.push(male);}
        for(int female : femalesInput){females.add(female);}
        int matchesCount = 0;

        while(!males.isEmpty() && !females.isEmpty()){
            int male = males.peek();
            int female = females.peek();
            boolean isStartOver = false;
            if(male <= 0){
                males.pop();
                isStartOver = true;
            }

            if(female <= 0){
                females.poll();
                isStartOver = true;
            }

            if(male > 0 && male % 25 == 0){
                males.pop();
                males.pop();
                isStartOver = true;
            }
            if(female > 0 && female % 25 == 0){
                females.poll();
                females.poll();
                isStartOver = true;
            }

            if(!isStartOver){
                if(male == female){
                    males.pop();
                    females.poll();
                    matchesCount++;
                }else{
                    females.poll();
                    male -= 2;
                    males.pop();
                    males.push(male);
                }
            }
        }

        System.out.printf("Matches: %d%n", matchesCount);
        System.out.print("Males left: ");
        if(males.isEmpty()){
            System.out.println("none");
        }else{
            while (males.size() > 1){
                System.out.printf("%d, ", males.pop());
            }
            System.out.println(males.pop());
        }

        System.out.print("Females left: ");
        if(females.isEmpty()){
            System.out.println("none");
        }else{
            while (females.size() > 1){
                System.out.printf("%d, ", females.poll());
            }
            System.out.println(females.poll());
        }
    }
}
