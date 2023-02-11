import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numsList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int sumOfRemovedNums = 0;

        while(numsList.size() != 0){
            int currentIndex = Integer.parseInt(scan.nextLine());

            if(currentIndex < 0){
                int firstElement = numsList.get(0);
                sumOfRemovedNums += firstElement;
                numsList.set(0, numsList.get(numsList.size()-1));
                adjustValues(numsList, firstElement);

            }else if(currentIndex >= 0 && currentIndex < numsList.size()){
                int elementValue = numsList.get(currentIndex);
                sumOfRemovedNums += elementValue;
                numsList.remove(currentIndex);
                adjustValues(numsList, elementValue);

            }else{//if currentIndex > last index
                int lastElement = numsList.get(numsList.size() - 1);
                sumOfRemovedNums += lastElement;
                numsList.set(numsList.size() - 1, numsList.get(0));
                adjustValues(numsList, lastElement);
            }
        }

        System.out.println(sumOfRemovedNums);
    }

    public static void adjustValues(List<Integer> list, int baselineNum){
        for(int i = 0; i < list.size(); i++){
            int currentElement = list.get(i);

            if(currentElement <= baselineNum){
                list.set(i, currentElement + baselineNum);
            }else{
                list.set(i, currentElement - baselineNum);
            }
        }
    }
}
