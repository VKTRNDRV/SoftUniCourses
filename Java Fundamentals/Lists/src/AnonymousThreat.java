import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> elementsList = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());

        while (true){
            String[] currentCommand = scan.nextLine().split(" ");
            if(currentCommand[0].equals("3:1")){break;}

            switch (currentCommand[0]){
                case "merge":
                    int firstIndex = Integer.parseInt(currentCommand[1]);
                    int lastIndex = Integer.parseInt(currentCommand[2]);
                    mergeElements(elementsList, firstIndex, lastIndex);
                    break;

                case "divide":
                    int index = Integer.parseInt(currentCommand[1]);
                    int numOfPartitions = Integer.parseInt(currentCommand[2]);
                    divideElements(elementsList, index,numOfPartitions);
                    break;
            }
        }

        for(String currentElement : elementsList){
            System.out.printf("%s ", currentElement);
        }
    }

    public static void mergeElements(List<String> list, int startIndex, int endIndex){

        //making startIndex and endIndex fit the array
        startIndex = Math.max(0, startIndex);
        if(startIndex >= list.size()){
            startIndex = list.size() - 1;
        }
        endIndex = Math.min(list.size() - 1, endIndex);
        StringBuilder mergedElement = new StringBuilder();

        //adding every element that is to be merged to mergedElement
        for (int i = startIndex; i <= endIndex; i++) {
            mergedElement.append(list.get(startIndex));
            list.remove(startIndex);
        }

        //adding mergedElement to the list
        list.add(startIndex, mergedElement.toString());
    }

    public static void divideElements(List<String> list, int index, int numOfPartitions){
        int elementLength = list.get(index).length();
        int partitionLength = elementLength / numOfPartitions; //integer division, the last partition ends up being the longest
        String element = list.get(index);
        list.remove(index);

        //adding every char of the element to a char list
        List<Character> elementCharList = new ArrayList<>();
        for (int j = 0; j < element.length(); j++) {
            elementCharList.add(element.charAt(j));
        }

        //iterating every partition except the last (long) one where nothing needs to be done
        for (int i = 1; i < numOfPartitions ; i++) {

            //iterating for every char of the current partition - adding it to the new element and removing it from elementCharList
            StringBuilder elementToBeAdded = new StringBuilder();
            for (int j = 0; j < partitionLength; j++) {
                elementToBeAdded.append(elementCharList.get(0));
                elementCharList.remove(0);
            }

            //adding the new element to the initial list
            list.add(index + (i - 1), elementToBeAdded.toString());
        }

        //adding the last long partition in place of the old element
        StringBuilder partitionedLastElement = new StringBuilder();
        for (int i = 0; i < elementCharList.size(); i++) {
            partitionedLastElement.append(elementCharList.get(i));
        }
        list.add((index + numOfPartitions) - 1, partitionedLastElement.toString());
    }
}
