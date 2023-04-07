package Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<BankAccount> bankAccounts = new ArrayList<>();
        while (true){
            String[] commandArr = scanner.nextLine().split(" ");
            if(commandArr[0].equals("End")){break;}
            if(commandArr[0].equals("Create")){
                BankAccount bankAccount = new BankAccount();
                bankAccounts.add(bankAccount);
                System.out.printf("Account ID%d created%n", bankAccount.getId());

            } else if (commandArr[0].equals("Deposit")) {
                int id = Integer.parseInt(commandArr[1]);
                double depositAmount = Double.parseDouble(commandArr[2]);
                if(existsInList(bankAccounts, id)){
                    BankAccount bankAccount = getBankAccountById(bankAccounts, id);
                    bankAccount.deposit(depositAmount);
                    System.out.printf("Deposited %.0f to ID%d%n", depositAmount, bankAccount.getId());
                }else{
                    System.out.println("Account does not exist");
                }
                
            } else if (commandArr[0].equals("SetInterest")) {
                double interestRate = Double.parseDouble(commandArr[1]);
                BankAccount.setInterestRate(interestRate);
                
            } else if (commandArr[0].equals("GetInterest")) {
                int id = Integer.parseInt(commandArr[1]);
                int years = Integer.parseInt(commandArr[2]);
                if(existsInList(bankAccounts, id)){
                    BankAccount bankAccount = getBankAccountById(bankAccounts, id);
                    double interest = bankAccount.getInterest(years);
                    System.out.printf("%.2f%n", interest);

                }else{
                    System.out.println("Account does not exist");
                }
            }
        }
    }

    public static BankAccount getBankAccountById(List<BankAccount> list, int id){
        for(BankAccount bankAccount : list){
            if (bankAccount.getId() == id){
                return bankAccount;
            }
        }

        return null;
    }

    public static boolean existsInList(List<BankAccount> list, int id){
        for(BankAccount bankAccount : list){
            if (bankAccount.getId() == id){
                return true;
            }
        }

        return false;
    }
}
