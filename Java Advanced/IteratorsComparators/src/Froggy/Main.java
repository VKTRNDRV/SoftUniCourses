package Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lake lake = new Lake();
        int[] nums = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for(int n : nums){
            lake.add(n);
        }

        List<Integer> output = new ArrayList<>();
        lake.forEach(output::add);

        for (int i = 0; i < output.size(); i++) {
            if(i < output.size() - 1){
                System.out.printf("%d, ", output.get(i));
            }else{
                System.out.println(output.get(i));
            }
        }


    }
}
