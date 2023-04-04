import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<Double, Integer> realNumsCountMap = new LinkedHashMap<>();
        double[] doublesArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        for(double realNum : doublesArr){
            if(realNumsCountMap.containsKey(realNum)){
                realNumsCountMap.put(realNum, realNumsCountMap.get(realNum) + 1);
            }else{
                realNumsCountMap.put(realNum, 1);
            }
        }

        for(Map.Entry<Double, Integer> entry : realNumsCountMap.entrySet()){
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
