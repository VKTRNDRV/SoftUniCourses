package CustomList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomList<String> customList = new CustomList<String>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            String command = scanner.nextLine();
            String[] commandParts = command.split(" ");

            switch (commandParts[0].toUpperCase()) {
                case "ADD":
                    customList.add(commandParts[1]);
                    break;
                case "REMOVE":
                    int indexToRemove = Integer.parseInt(commandParts[1]);
                    customList.remove(indexToRemove);
                    break;
                case "CONTAINS":
                    String elementToCheck = commandParts[1];
                    System.out.println(customList.contains(elementToCheck));
                    break;
                case "SWAP":
                    int index1 = Integer.parseInt(commandParts[1]);
                    int index2 = Integer.parseInt(commandParts[2]);
                    customList.swap(index1, index2);
                    break;
                case "GREATER":
                    String elementToCompare = commandParts[1];
                    int countGreaterThan = customList.countGreaterThan(elementToCompare);
                    System.out.println(countGreaterThan);
                    break;
                case "MAX":
                    System.out.println(customList.getMax());
                    break;
                case "MIN":
                    System.out.println(customList.getMin());
                    break;
                case "PRINT":
                    for (String element : customList.getElements()) {
                        System.out.println(element);
                    }
                    break;
                case "END":
                    running = false;
                    break;
                case "SORT":
                    Sorter.sort(customList);
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
        scanner.close();
    }
}
