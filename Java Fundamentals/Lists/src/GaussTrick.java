import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scan.nextLine().split(" "))
                                            .map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 1; i <= (nums.size() / 2); i++){
            int currentItemIndex = i - 1;
            int currentOutput = nums.get(currentItemIndex) + nums.get((nums.size() - currentItemIndex)-1);

            System.out.printf("%d ",currentOutput);
        }
        if(nums.size() % 2 != 0){
            System.out.println(nums.get(nums.size() / 2));
        }
    }
}
