package ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListyIterator listyIterator = new ListyIterator();
        while (true){
            String[] command = scanner.nextLine().split("\\s+");
            if(command[0].equals("END")){break;}

            switch (command[0]){
                case "Create":
                    if(command.length > 1){
                        listyIterator = new ListyIterator(Arrays.copyOfRange(command, 1, command.length));
                    }
                    break;

                case "Move":
                    System.out.println(listyIterator.move());
                    break;

                case "Print":
                    try{
                        listyIterator.print();
                    }catch (IllegalStateException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;

                case "PrintAll":
                    try {
                        listyIterator.printAll();
                    }catch (IllegalStateException e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}
