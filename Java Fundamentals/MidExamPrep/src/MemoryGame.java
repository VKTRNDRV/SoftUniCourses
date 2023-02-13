import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> elementsList = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        elementsList.remove("");
        int movesCount = 0;
        boolean isGameWon = false;

        while(true){
            String[] currentCommand = scan.nextLine().split(" ");
            if(currentCommand[0].equals("end")){
                break;
            }

            movesCount++;
            int firstIndex = Math.min(Integer.parseInt(currentCommand[0]), Integer.parseInt(currentCommand[1]));
            int secondIndex = Math.max(Integer.parseInt(currentCommand[0]), Integer.parseInt(currentCommand[1]));
            boolean areIndexesValid = areIndexesValid(firstIndex, secondIndex, elementsList);

            //valid move
            if(areIndexesValid){

                //elements match
                if(elementsList.get(firstIndex).equals(elementsList.get(secondIndex))){
                    System.out.printf("Congrats! You have found matching elements - %s!%n",elementsList.get(firstIndex));
                    elementsList.remove(secondIndex);
                    elementsList.remove(firstIndex);

                }else{//elements do not match
                    System.out.println("Try again!");
                }

            }else{ //illegal move
                int middleIndex = (elementsList.size() / 2);
                System.out.println("Invalid input! Adding additional elements to the board");
                String addedElement = "-" + movesCount + "a";
                elementsList.add(middleIndex, addedElement);
                elementsList.add(middleIndex, addedElement);
            }


            //check if game is won
            if(elementsList.size() == 0){
                System.out.printf("You have won in %d turns!%n", movesCount);
                isGameWon = true;
                break;
            }
        }

        if(!isGameWon){
            System.out.println("Sorry you lose :(");
            for (String currentElement : elementsList){
                System.out.printf("%s ",currentElement);
            }
        }
    }

    public static boolean areIndexesValid(int index1, int index2, List<String> list){
        boolean areValid = true;

        if(index1 == index2){
         areValid = false;
        }
        if(index1 < 0 || index1 >= list.size()){
            areValid = false;
        }
        if(index2 < 0 || index2 >= list.size()){
            areValid = false;
        }

        return areValid;
    }
}
