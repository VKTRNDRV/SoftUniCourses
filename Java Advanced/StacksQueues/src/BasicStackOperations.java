import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] vars = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();

        int pushMax = vars[0];
        int popMax = vars[1];
        int testNum = vars[2];
        ArrayDeque<Integer> nums = new ArrayDeque<>();

        for (int i = 0; i < pushMax; i++) {
            int num = scanner.nextInt();
            nums.push(num);
        }

        for (int i = 0; i < popMax && !nums.isEmpty(); i++) {
            nums.pop();
        }

        if(nums.contains(testNum)){
            System.out.println(true);
        }else{
            int minNum;
            if(nums.isEmpty()){
                minNum = 0;
            }else{
                minNum = nums.pop();
            }

            while (!nums.isEmpty()){
                int poppedNum = nums.pop();
                if(poppedNum < minNum){
                    minNum = poppedNum;
                }
            }

            System.out.println(minNum);
        }
    }
}
