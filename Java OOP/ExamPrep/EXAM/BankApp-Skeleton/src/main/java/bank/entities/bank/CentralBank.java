package bank.entities.bank;

import bank.common.ConstantMessages;
import bank.entities.client.Adult;
import bank.entities.client.Client;

public class CentralBank extends BaseBank{
    public CentralBank(String name) {
        super(name, 50);
    }

    @Override
    public void addClient(Client client) {
        if(!client.getClass().equals(Adult.class)){
            throw new IllegalArgumentException(ConstantMessages
                    .UNSUITABLE_BANK);
        }
        super.addClient(client);
    }
}
