import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numsList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (true){
            String[] currentCommand = scan.nextLine().split(" ");
            if(currentCommand[0].equals("end")){
                break;
            }

            switch (currentCommand[0]){
                case "swap":
                    int swapIndex1 = Integer.parseInt(currentCommand[1]);
                    int swapIndex2 = Integer.parseInt(currentCommand[2]);
                    int temp = numsList.get(swapIndex1);
                    numsList.set(swapIndex1, numsList.get(swapIndex2));
                    numsList.set(swapIndex2, temp);
                    break;

                case "multiply":
                    int multiplyIndex1 = Integer.parseInt(currentCommand[1]);
                    int multiplyIndex2 = Integer.parseInt(currentCommand[2]);
                    numsList.set(multiplyIndex1, (numsList.get(multiplyIndex1) * numsList.get(multiplyIndex2)));
                    break;

                case "decrease":
                    for(int i = 0; i < numsList.size(); i++){
                        int currentNum = numsList.get(i);
                        numsList.set(i, currentNum - 1);
                    }
                    break;
            }
        }

        for(int i = 0; i < numsList.size(); i++){
            int currentNum = numsList.get(i);
            if(i < numsList.size()-1){
                System.out.printf("%d, ", currentNum);
            }else{
                System.out.printf("%d",currentNum);
            }
        }
    }
}
