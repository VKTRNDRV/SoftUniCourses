import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> targetsList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (true){
            String[] currentCommand = scan.nextLine().split(" ");
            if(currentCommand[0].equals("End")){
                break;
            }
            int commandIndex = Integer.parseInt(currentCommand[1]);

            switch (currentCommand[0]){
                case "Shoot":
                    int shootPower = Integer.parseInt(currentCommand[2]);
                    if(commandIndex >= 0 && commandIndex < targetsList.size()){
                        shootTarget(targetsList, commandIndex, shootPower);
                    }
                    break;

                case "Add":
                    int addValue = Integer.parseInt(currentCommand[2]);
                    if(commandIndex >= 0 && commandIndex < targetsList.size()){
                        targetsList.add(commandIndex, addValue);
                    }else{
                        System.out.println("Invalid placement!");
                    }
                    break;

                case "Strike":
                    int strikeRadius = Integer.parseInt(currentCommand[2]);
                    int firstIndex = commandIndex - strikeRadius;
                    int lastIndex = commandIndex + strikeRadius;
                    if(firstIndex >= 0 && lastIndex < targetsList.size()){
                        strikeTarget(targetsList, commandIndex, strikeRadius);
                    }else{
                        System.out.println("Strike missed!");
                    }
                    break;
            }
        }

        for (int i = 0; i < targetsList.size(); i++) {
            int currentElement = targetsList.get(i);
            if(i != targetsList.size() - 1){
                System.out.printf("%d|",currentElement);
            }else{
                System.out.print(currentElement);
            }
        }
    }

    public static void shootTarget(List<Integer> list, int shotIndex, int shotPower){
        int targetValue = list.get(shotIndex);
        if(shotPower >= targetValue){
            list.remove(shotIndex);
        }else{
            list.set(shotIndex, targetValue - shotPower);
        }
    }

    public static void strikeTarget(List<Integer> list, int strikeIndex, int strikeRadius){
        int firstIndex = strikeIndex - strikeRadius;
        int lastIndex = strikeIndex + strikeRadius;

        for (int i = firstIndex; i <= lastIndex; i++){
            list.remove(firstIndex);
        }
    }
}
