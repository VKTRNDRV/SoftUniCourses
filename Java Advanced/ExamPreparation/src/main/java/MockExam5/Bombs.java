package MockExam5;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // reading input
        int[] effectsInput = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] casingsInput = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> effects = new ArrayDeque<>();
        ArrayDeque<Integer> casings = new ArrayDeque<>();

        for(int b : effectsInput){effects.add(b);}
        for(int c : casingsInput){casings.push(c);}

        int daturaBombsCount = 0;
        int cherryBombsCount = 0;
        int smokeBombsCount = 0;
        boolean isBombPouchFilled = false;

        // iterating until empty
        while (!effects.isEmpty() && !casings.isEmpty()){
            int effect = effects.peek();
            int casing = casings.peek();

            int sum = effect + casing;

            if(sum == 40){
                daturaBombsCount++;
                effects.poll();
                casings.pop();

            } else if (sum == 60) {
                cherryBombsCount++;
                effects.poll();
                casings.pop();

            } else if (sum == 120) {
                smokeBombsCount++;
                effects.poll();
                casings.pop();

            } else {
                casing = casings.pop();
                casing -= 5;
                casings.push(casing);
            }

            if(daturaBombsCount >= 3
                    && cherryBombsCount >= 3
                    && smokeBombsCount >= 3){
                isBombPouchFilled = true;
                break;
            }
        }

        // printing output
        if(isBombPouchFilled){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else{
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        System.out.print("Bomb Effects: ");
        if(effects.isEmpty()){
            System.out.println("empty");
        }else{
            while (effects.size() > 1){
                System.out.printf("%d, ", effects.poll());
            }

            System.out.printf("%d\n", effects.poll());
        }

        System.out.print("Bomb Casings: ");
        if(casings.isEmpty()){
            System.out.println("empty");
        }else{
            while (casings.size() > 1){
                System.out.printf("%d, ", casings.pop());
            }

            System.out.printf("%d\n", casings.pop());
        }

        System.out.printf("Cherry Bombs: %d\n", cherryBombsCount);
        System.out.printf("Datura Bombs: %d\n", daturaBombsCount);
        System.out.printf("Smoke Decoy Bombs: %d", smokeBombsCount);
    }
}
