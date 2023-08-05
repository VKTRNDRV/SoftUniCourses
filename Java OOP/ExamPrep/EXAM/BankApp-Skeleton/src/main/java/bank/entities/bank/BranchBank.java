package bank.entities.bank;

import bank.common.ConstantMessages;
import bank.common.ExceptionMessages;
import bank.entities.client.Client;
import bank.entities.client.Student;

public class BranchBank extends BaseBank{
    public BranchBank(String name) {
        super(name, 25);
    }

    @Override
    public void addClient(Client client) {
        if(!client.getClass().equals(Student.class)){
            throw new IllegalArgumentException(ConstantMessages
                    .UNSUITABLE_BANK);
        }
        super.addClient(client);
    }
}
