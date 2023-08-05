package bank.entities.bank;

import bank.common.ExceptionMessages;
import bank.entities.client.Client;
import bank.entities.loan.Loan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseBank implements Bank{

    private String name;

    private int capacity;

    private Collection<Loan> loans;

    private Collection<Client> clients;

    public BaseBank(String name, int capacity){
        setName(name);
        this.capacity = capacity;
        this.loans = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages
                    .BANK_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Client> getClients() {
        return clients;
    }

    @Override
    public Collection<Loan> getLoans() {
        return loans;
    }

    @Override
    public void addClient(Client client) {
        if(this.clients.size() >= this.capacity){
            throw new IllegalStateException(ExceptionMessages
                    .NOT_ENOUGH_CAPACITY_FOR_CLIENT);
        }
        this.clients.add(client);
    }

    @Override
    public void removeClient(Client client) {
        this.clients.remove(client);
    }

    @Override
    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }

    @Override
    public int sumOfInterestRates() {
        int sum = 0;
        for(Loan loan : this.loans){
            sum += loan.getInterestRate();
        }
        return sum;
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Name: %s, Type: %s",
                        this.name, this.getClass().getSimpleName()))
                .append(System.lineSeparator());
        List<String> clientNames = new ArrayList<>();
        this.clients.forEach(c -> clientNames.add(c.getName()));
        if(clientNames.size() == 0){
            clientNames.add("none");
        }
        output.append(String.format("Clients: %s",
                        String.join(", ", clientNames)))
                .append(System.lineSeparator())
                .append(String.format("Loans: %d, Sum of interest rates: %d",
                        this.loans.size(), sumOfInterestRates()));

        return output.toString().trim();
    }
}
