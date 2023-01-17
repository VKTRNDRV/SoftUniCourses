import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double cashBalance = 0;
        String currentInput = scan.nextLine();

        //calculating cashBalance//
        while(!currentInput.equals("Start")){
            double currentInputDouble = Double.parseDouble(currentInput);
            if(currentInputDouble == 0.1 || currentInputDouble == 0.2 || currentInputDouble == 0.5 || currentInputDouble == 1 || currentInputDouble == 2){
                cashBalance += currentInputDouble;
            }else{
                System.out.printf("Cannot accept %.2f%n",currentInputDouble);
            }
            currentInput = scan.nextLine();
        }

        //purchasing products if cash available//
        currentInput = scan.nextLine();
        while(!currentInput.equals("End")){
            if(currentInput.equals("Nuts") || currentInput.equals("Water") || currentInput.equals("Crisps") || currentInput.equals("Soda") || currentInput.equals("Coke")){
                if(currentInput.equals("Nuts")){
                    if(cashBalance >= 2){
                        cashBalance -= 2;
                        System.out.println("Purchased Nuts");
                    }else{
                        System.out.println("Sorry, not enough money");
                    }
                } else if (currentInput.equals("Water")) {
                    if(cashBalance >= 0.7){
                        cashBalance -= 0.7;
                        System.out.println("Purchased Water");
                    }else{
                        System.out.println("Sorry, not enough money");
                    }
                } else if (currentInput.equals("Crisps")) {
                    if(cashBalance >= 1.5){
                        cashBalance -= 1.5;
                        System.out.println("Purchased Crisps");
                    }else{
                        System.out.println("Sorry, not enough money");
                    }
                } else if (currentInput.equals("Soda")) {
                    if(cashBalance >= 0.8){
                        cashBalance -= 0.8;
                        System.out.println("Purchased Soda");
                    }else{
                        System.out.println("Sorry, not enough money");
                    }
                } else if (currentInput.equals("Coke")) {
                    if(cashBalance >= 1){
                        cashBalance -= 1;
                        System.out.println("Purchased Coke");
                    }else{
                        System.out.println("Sorry, not enough money");
                    }
                }
            }else{
                System.out.println("Invalid product");
            }
            currentInput = scan.nextLine();
        }
        //printing out change//
        System.out.printf("Change: %.2f",cashBalance);
    }
}
