import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        
        List<Integer> outputList = mergeListsAlternating(firstList,secondList);

        for(int currentItem : outputList){
            System.out.printf("%d ",currentItem);
        }
    }

    public static List<Integer> mergeListsAlternating(List<Integer> firstList, List<Integer> secondList){
        
        int shorterListSize = Math.min(firstList.size(), secondList.size());
        int longerListSize = Math.max(firstList.size(), secondList.size());

        List<Integer> longerList = new ArrayList<>();
        if(firstList.size() >= secondList.size()){
            longerList = firstList;
        }else{
            longerList = secondList;
        }


        List<Integer> outputList = new ArrayList<>();

        int i = 0;
        while(i < shorterListSize) {
            outputList.add(firstList.get(i));
            outputList.add(secondList.get(i));
            i++;
        }

        while(i < longerListSize){
            outputList.add(longerList.get(i));
            i++;
        }

        return outputList;
    }
}
