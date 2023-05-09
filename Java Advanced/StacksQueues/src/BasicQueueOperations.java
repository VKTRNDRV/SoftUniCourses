import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] vars = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();

        int addMax = vars[0];
        int removeMax = vars[1];
        int testNum = vars[2];

        ArrayDeque<Integer> nums = new ArrayDeque<>();
        for (int i = 0; i < addMax; i++) {
            int n = scanner.nextInt();
            nums.add(n);
        }

        for (int i = 0; i < removeMax && !nums.isEmpty(); i++) {
            nums.pop();
        }

        if(nums.contains(testNum)){
            System.out.println(true);
        }else {
            int minNum;
            if(nums.isEmpty()){
                minNum = 0;
            }else{
                minNum = nums.remove();
            }

            while (!nums.isEmpty()){
                int n = nums.pop();
                if(n < minNum){
                    minNum = n;
                }
            }

            System.out.println(minNum);
        }
    }
}
