package bank.entities.client;

public class Adult extends BaseClient{
    public Adult(String name, String ID, double income) {
        super(name, ID, 4, income);
        setInterestIncrease(2);
    }

    // can only live in CentralBank
}
