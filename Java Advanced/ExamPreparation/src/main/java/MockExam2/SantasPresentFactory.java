package MockExam2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //reading input
        int[] matInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] magInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> materialsBoxes = new ArrayDeque<>();
        for(int box : matInput){materialsBoxes.push(box);}

        ArrayDeque<Integer> magicValues = new ArrayDeque<>();
        for(int value : magInput){magicValues.add(value);}

        int dollCount = 0;  int trainCount = 0; int bearCount = 0;  int bicycleCount = 0;
        int dollProduct = 150; int trainProduct = 250; int bearProduct = 300; int bicycleProduct = 400;

        boolean isDollTrainCrafted = false;
        boolean isBearBicycleCrafted = false;

        //iterating until task complete or boxes/values empty
        while (!materialsBoxes.isEmpty() && !magicValues.isEmpty()){
            int materials = materialsBoxes.pop();
            int magic = magicValues.poll();

            //pulling boxes and values until both are not zero
            while (materials == 0 && !materialsBoxes.isEmpty()){
                materials = materialsBoxes.pop();
            }
            while (magic == 0 && !magicValues.isEmpty()){
                magic = magicValues.poll();
            }

            int product = materials * magic;

            //performing operations as per requirements
            if(product < 0){
                product = materials + magic;
                materialsBoxes.push(product);

            }else if (product > 0){
                if(product == dollProduct){
                    dollCount++;

                } else if (product == trainProduct) {
                    trainCount++;

                } else if (product == bearProduct) {
                    bearCount++;

                } else if (product == bicycleProduct) {
                    bicycleCount++;

                }else{
                    materials += 15;
                    materialsBoxes.push(materials);
                }
            }else{//if product at this stage is 0 it means the last element in one or both deques is zero
                if(materials != 0){
                    materialsBoxes.push(materials);
                }

                if(magic != 0){
                    magicValues.addFirst(magic);
                }
            }

            if(dollCount == 1 && trainCount == 1){isDollTrainCrafted = true;}
            if(bearCount == 1 && bicycleCount == 1){isBearBicycleCrafted = true;}
        }

        //printing if is ok - weird logic
        if((isDollTrainCrafted && !isBearBicycleCrafted) ||
                ((!isDollTrainCrafted && isBearBicycleCrafted))){
            System.out.println("The presents are crafted! Merry Christmas!");
        }else{
            System.out.println("No presents this Christmas!");
        }

        //printing materials and magic values left
        if(!materialsBoxes.isEmpty()){
            System.out.print("Materials left: ");
            while (materialsBoxes.size() > 1){
                System.out.printf("%d, ", materialsBoxes.pop());
            }
            System.out.printf("%d%n", materialsBoxes.pop());
        }

        if(!magicValues.isEmpty()){
            System.out.print("Magic left: ");
            while (magicValues.size() > 1){
                System.out.printf("%d, ", magicValues.poll());
            }
            System.out.printf("%d%n", magicValues.poll());
        }

        //printing crafted presents alphabetically
        if(bicycleCount > 0){
            System.out.printf("Bicycle: %d%n", bicycleCount);
        }

        if(dollCount > 0){
            System.out.printf("Doll: %d%n", dollCount);
        }

        if(bearCount > 0){
            System.out.printf("Teddy bear: %d%n", bearCount);
        }

        if(trainCount > 0){
            System.out.printf("Wooden train: %d", trainCount);
        }
    }
}
