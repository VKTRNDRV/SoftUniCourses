import java.util.*;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numsList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int i = 0;
        while (i < numsList.size()){
            if(numsList.get(i) < 0){
                numsList.remove(i);
                i--;
            }
            i++;
        }

        if(numsList.size() != 0) {
            Collections.reverse(numsList);
            for(int currentNum : numsList){
                System.out.printf("%d ",currentNum);
            }
        }else{
            System.out.println("empty");
        }
    }
}
