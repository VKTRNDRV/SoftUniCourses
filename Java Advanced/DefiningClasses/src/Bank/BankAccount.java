package Bank;

public class BankAccount {
    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int idCounter = 1;
    private int id;
    private double balance;

    public BankAccount(){
        this.id = idCounter++;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }
    public double getBalance() {
        return balance;
    }

    public static void setInterestRate(double interestRate){
        BankAccount.interestRate = interestRate;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public double getInterest(int years){
        return BankAccount.interestRate * this.balance * years;
    }
}
