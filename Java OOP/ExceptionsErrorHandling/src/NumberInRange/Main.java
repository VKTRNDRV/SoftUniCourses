package NumberInRange;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] range = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();
        int lowerRange = Math.min(range[0], range[1]);
        int upperRange = Math.max(range[0], range[1]);
        System.out.printf("Range: [%d...%d]%n", lowerRange, upperRange);

        boolean isFound = false;
        while (!isFound) {
            String line = scanner.nextLine();
            try{
                int num = Integer.parseInt(line);
                if(isNumberInRange(lowerRange, upperRange, num)){
                    isFound = true;
                    System.out.println("Valid number: " + num);
                }else{
                    System.out.println("Invalid number: " + num);
                }

            }catch (Exception e){
                System.out.println("Invalid number: " + line);
            }
        }
    }

    private static boolean isNumberInRange(int start, int end, int testNum) {
        try {
            if (testNum >= start && testNum <= end) {
                return true;
            }else{
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
    }
}
