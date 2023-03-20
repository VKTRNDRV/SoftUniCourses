import java.util.ArrayDeque;
import java.util.Scanner;

public class MaxElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsCount = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numsStack = new ArrayDeque<>();
        for (int i = 0; i < commandsCount; i++) {
            String[] thisLine = scanner.nextLine().split(" ");
            switch (thisLine[0]){
                case "1"://push
                    numsStack.push(Integer.parseInt(thisLine[1]));
                    break;
                case "2"://delete
                    numsStack.pop();
                    break;

                case  "3"://print max
                    if(!numsStack.isEmpty()) {
                        int maxNum = numsStack.peek();
                        for (int j = 0; j < numsStack.size(); j++) {
                            int thisNum = numsStack.pop();
                            if (thisNum > maxNum) {maxNum = thisNum;}
                            numsStack.add(thisNum);
                        }
                        System.out.println(maxNum);
                        break;
                    }
            }
        }
    }
}
