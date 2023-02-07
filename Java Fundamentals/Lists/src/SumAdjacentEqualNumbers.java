import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Double> nums = Arrays.stream(scan.nextLine().split(" "))
                .map(Double::parseDouble).collect(Collectors.toList());

        for (int i = 0; i < nums.size() - 1; i++){
            if(nums.get(i).equals(nums.get(i+1))){
                nums.set(i, (nums.get(i) + nums.get(i+1)));
                nums.remove(i+1);
                i = -1;
            }
        }

        String output = "";
        for(Double item : nums){
            output += (new DecimalFormat("0.#").format(item) + " ");
        }

        System.out.println(output);
    }
}