import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (true){
            String[] currentCommand = Arrays.stream(scan.nextLine().split(" ")).toArray(String[]::new);

            if(currentCommand[0].equals("end")){
                break;
            }

            switch (currentCommand[0]){
                case "Add": numbers.add(Integer.parseInt(currentCommand[1])); break;

                case "Remove":
                    int numToBeRemoved = Integer.parseInt(currentCommand[1]);
                    numbers.remove(Integer.valueOf(numToBeRemoved));
                    break;

                case "RemoveAt":
                    int indexToBeRemoved = Integer.parseInt(currentCommand[1]);
                    numbers.remove(indexToBeRemoved);
                    break;

                case "Insert":
                    int numToBeInserted = Integer.parseInt(currentCommand[1]);
                    int indexToBeAddedAt = Integer.parseInt(currentCommand[2]);
                    numbers.add(indexToBeAddedAt,numToBeInserted);
                    break;

                case "Contains":
                    int numToBeChecked = Integer.parseInt(currentCommand[1]);
                    if(numbers.contains(numToBeChecked)){
                        System.out.println("Yes");
                    }else{
                        System.out.println("No such number");
                    }
                    break;

                case "Print":
                    String evenOrOdd = currentCommand[1];
                    if(evenOrOdd.equals("even")){
                        for (int i = 0; i < numbers.size(); i++) {
                            if(numbers.get(i) % 2 == 0){
                                System.out.printf("%d ",numbers.get(i));
                            }
                        }
                        System.out.println();
                    }else if(evenOrOdd.equals("odd")){
                        for (int i = 0; i < numbers.size(); i++) {
                            if(numbers.get(i) % 2 != 0){
                                System.out.printf("%d ",numbers.get(i));
                            }
                        }
                        System.out.println();
                    }
                    break;

                case "Get":
                    int sum = 0;
                    for(int currentNum : numbers){
                        sum += currentNum;
                    }
                    System.out.println(sum);
                    break;

                case "Filter":
                    int filterCommandValue = Integer.parseInt(currentCommand[2]);
                    printFilteredList(numbers,currentCommand[1],filterCommandValue);
                    break;
            }
        }

//        for(int currentItem : numbers){
//            System.out.printf("%d ",currentItem);
//        }
    }

    public static void printFilteredList(List<Integer> list, String command, int filterValue){
        switch (command){
            case "<":
                for (int currentNum : list) {
                    if (currentNum < filterValue) {
                        System.out.printf("%d ", currentNum);
                    }
                }
                System.out.println();
                break;

            case "<=":
                for (int currentNum : list) {
                    if (currentNum <= filterValue) {
                        System.out.printf("%d ", currentNum);
                    }
                }
                System.out.println();
                break;

            case ">=":
                for (int currentNum : list) {
                    if (currentNum >= filterValue) {
                        System.out.printf("%d ", currentNum);
                    }
                }
                System.out.println();
                break;

            case ">":
                for (int currentNum : list) {
                    if (currentNum > filterValue) {
                        System.out.printf("%d ", currentNum);
                    }
                }
                System.out.println();
                break;
        }
    }
}
