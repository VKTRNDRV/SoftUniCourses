import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numsList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        while(true){
            String[] currentCommand = scan.nextLine().split(" ");
            if(currentCommand[0].equals("end")){break;}

            switch (currentCommand[0]){
                case "Delete":
                    int valueToBeDeleted = Integer.parseInt(currentCommand[1]);
                    for (int i = 0; i < numsList.size(); i++) {
                        if(numsList.get(i) == valueToBeDeleted){
                            numsList.remove(i);
                            i--;
                        }
                    }
                    break;

                case "Insert":
                    int index = Integer.parseInt(currentCommand[2]);
                    int value = Integer.parseInt(currentCommand[1]);
                    numsList.add(index,value);
                    break;
            }
        }

        for(int currentNum : numsList){
            System.out.printf("%d ",currentNum);
        }
    }
}
