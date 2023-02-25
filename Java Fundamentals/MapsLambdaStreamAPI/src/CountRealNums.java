import java.text.DecimalFormat;
import java.util.*;

public class CountRealNums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double[] nums = Arrays.stream(scan.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        TreeMap<Double, Integer> numCounts = new TreeMap<>();
        for(double currentNum : nums){
            if(!numCounts.containsKey(currentNum)){
                numCounts.put(currentNum, 1);
            }else{
                numCounts.put(currentNum, numCounts.get(currentNum) + 1);
            }
        }

        for(Map.Entry<Double, Integer> currentEntry : numCounts.entrySet()){
            DecimalFormat df = new DecimalFormat("#.##########");
            System.out.printf("%s -> %d%n", df.format(currentEntry.getKey()), currentEntry.getValue());
        }
    }
}
