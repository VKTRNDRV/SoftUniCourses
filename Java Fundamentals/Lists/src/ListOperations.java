import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numsList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (true){
            String[] currentCommand = scan.nextLine().split(" ");
            if(currentCommand[0].equals("End")){break;}

            switch (currentCommand[0]){
                case "Add":
                    numsList.add(Integer.parseInt(currentCommand[1]));
                    break;

                case "Insert":
                    int index = Integer.parseInt(currentCommand[2]);
                    if(isValidIndex(numsList.size(),index)) {
                        int value = Integer.parseInt(currentCommand[1]);
                        numsList.add(index, value);
                    }else{
                        System.out.println("Invalid index");
                    }
                    break;

                case "Remove":
                    int indexToRemove = Integer.parseInt(currentCommand[1]);
                    if(isValidIndex(numsList.size(),indexToRemove)) {
                        numsList.remove(indexToRemove);
                    }else{
                        System.out.println("Invalid index");
                    }
                    break;

                case "Shift":
                    int numOfShifts = Integer.parseInt(currentCommand[2]);

                    switch(currentCommand[1]){
                        case "left":
                            for (int i = 1; i <= numOfShifts; i++){
                                int firstNum = numsList.get(0);
                                numsList.add(firstNum);
                                numsList.remove(0);
                            }
                            break;
                        case "right":
                            for (int i = 1; i <= numOfShifts; i++) {
                                int lastNum = numsList.get(numsList.size()-1);
                                numsList.add(0, lastNum);
                                numsList.remove(numsList.size()-1);
                            }
                            break;
                    }
                    break;
            }
        }

        for(int currentNum : numsList){
            System.out.printf("%d ",currentNum);
        }
    }

    public static boolean isValidIndex(int listSize, int index){
        boolean isValid = (index >= 0 && index < listSize);
        return isValid;
    }
}
