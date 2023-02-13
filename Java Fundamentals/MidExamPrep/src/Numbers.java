import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numsList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        //calculating average
        double averageValue = 0;
        for(int currentNum : numsList){averageValue += currentNum;}
        averageValue = averageValue / numsList.size();

        //removing all nums less than average
        for(int i = 0; i < numsList.size(); i++){
            int currentNum = numsList.get(i);
            if(currentNum <= averageValue){
                numsList.remove(i);
                i--;
            }
        }

        if(numsList.size() == 0){
            System.out.print("No");
        }else{
            Collections.sort(numsList);
            Collections.reverse(numsList);
             for(int i = 0; i < numsList.size() && i<5; i++){
                 System.out.printf("%d ", numsList.get(i));
             }
        }
    }
}
