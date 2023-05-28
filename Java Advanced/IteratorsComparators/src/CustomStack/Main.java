package CustomStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomStack customStack = new CustomStack();
        while (true){
            String[] command = scanner.nextLine().split("\\s+");
            if(command[0].equals("END")){
                customStack.forEach(System.out::println);
                customStack.forEach(System.out::println);
                break;
            }

            switch (command[0]){
                case "Push":
                    command = Arrays.copyOfRange(command, 1, command.length);
                    int[] nums = new int[command.length];
                    for (int i = 0; i < command.length; i++) {
                        String str = command[i];
                        if(str.contains(",")){
                            str = str.replace(",", "");
                        }
                        nums[i] = Integer.parseInt(str);
                    }

                    customStack.push(nums);
                    break;
                case "Pop":
                    try {
                        customStack.pop();
                    }catch (IllegalStateException e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}
