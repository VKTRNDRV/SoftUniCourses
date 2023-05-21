import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();

        Function<Integer, Integer> add = n -> n + 1;
        Function<Integer, Integer> multiply = n -> n * 2;
        Function<Integer, Integer> subtract = n -> n - 1;
        Consumer<int[]> print = arr -> {for(int n : arr){System.out.printf("%d ", n);}};

//        boolean isPrint = false;
        while (true){
            String command = scanner.nextLine();
            if(command.equals("end")){
//                if(isPrint){
//                    print.accept(nums);
//                }
                break;
            }

            switch (command){
                case "add":
                    for (int i = 0; i < nums.length; i++) {
                        nums[i] = add.apply(nums[i]);
                    }
                    break;

                case "multiply":
                    for (int i = 0; i < nums.length; i++) {
                        nums[i] = multiply.apply(nums[i]);
                    }
                    break;

                case "subtract":
                    for (int i = 0; i < nums.length; i++) {
                        nums[i] = subtract.apply(nums[i]);
                    }
                    break;

                case "print":
                    print.accept(nums);
                    System.out.println();
                    break;
            }
        }
    }
}
