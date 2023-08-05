package bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTests {

    private Bank bank;

    @Before
    public void setUp(){
        this.bank = new Bank("bank1", 5);
    }

    // getName returns name
    @Test
    public void testGetNameReturnsName(){
        Assert.assertEquals("bank1", bank.getName());
    }

    // create bank with null name throws NullPointer
    @Test(expected = NullPointerException.class)
    public void testCreateBankWithNullNameThrowsNullPointerException(){
        new Bank(null, 10);
    }

    // create bank with whitespace name throws NullPointer
    @Test(expected = NullPointerException.class)
    public void testCreateBankWithWhitespaceNameThrowsNullPointerException(){
        new Bank("   ", 10);
    }


    // getCapacity returns capacity
    @Test
    public void testGetCapacityReturnsCapacity(){
        Assert.assertEquals(5, bank.getCapacity());
    }

    // create bank with negative capacity throws IllegalArgument
    @Test(expected = IllegalArgumentException.class)
    public void testCreateBankWithNegativeCapacityThrowsIllegalArgumentException(){
        new Bank("bank2", -5);
    }


    // getCount returns count of clients
    @Test
    public void testGetCountReturnsCountOfClients(){
        Assert.assertEquals(0, bank.getCount());

        bank.addClient(new Client("Client 1"));
        Assert.assertEquals(1, bank.getCount());

        bank.addClient(new Client("Client 2"));
        bank.addClient(new Client("Client 3"));
        Assert.assertEquals(3, bank.getCount());
    }


    // addClient adds client
    @Test
    public void testAddClientAddsClient(){
        bank.addClient(new Client("Client 1"));
        Assert.assertEquals(1, bank.getCount());
    }

    // addClient to full bank throws IllegalArgument
    @Test(expected = IllegalArgumentException.class)
    public void testAddClientToFullBankThrowsIllegalArgumentException(){
        bank.addClient(new Client("Client 1"));
        bank.addClient(new Client("Client 2"));
        bank.addClient(new Client("Client 3"));
        bank.addClient(new Client("Client 4"));
        bank.addClient(new Client("Client 5"));
        bank.addClient(new Client("Client 6"));
    }


    // removeClient removes client
    @Test
    public void testRemoveClientRemovesClient(){
        Client client = new Client("Client 1");
        bank.addClient(client);
        Assert.assertEquals(1, bank.getCount());

        bank.removeClient("Client 1");
        Assert.assertEquals(0, bank.getCount());
    }

    // removeClient non-existing client throws IllegalArgument
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingClientThrowsIllegalArgumentException(){
        bank.removeClient("Non-existing Client");
    }


    // loanWithdrawal sets client's approvedForLoan to false and returns client
    @Test
    public void testLoanWithdrawalSetsApprovedForLoanToFalseAndReturnsClient(){
        Client client = new Client("Client 1");
        bank.addClient(client);

        Client withdrawnClient = bank.loanWithdrawal("Client 1");
        Assert.assertFalse(withdrawnClient.isApprovedForLoan());
        Assert.assertEquals(client, withdrawnClient);
    }

    // loanWithdrawal non-existing client throws IllegalArgument
    @Test(expected = IllegalArgumentException.class)
    public void testLoanWithdrawalNonExistingClientThrowsIllegalArgumentException(){
        bank.loanWithdrawal("Non-existing Client");
    }


    // statistics returns the correct string
    @Test
    public void testStatisticsReturnsCorrectString(){
        Client client1 = new Client("Client 1");
        Client client2 = new Client("Client 2");
        bank.addClient(client1);
        bank.addClient(client2);

        Assert.assertEquals("The client Client 1, Client 2 is at the bank1 bank!", bank.statistics());
    }
}
