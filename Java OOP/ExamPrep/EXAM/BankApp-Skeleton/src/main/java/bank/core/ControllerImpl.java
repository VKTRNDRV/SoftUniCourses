package bank.core;

import bank.common.ConstantMessages;
import bank.common.ExceptionMessages;
import bank.entities.bank.Bank;
import bank.entities.bank.BranchBank;
import bank.entities.bank.CentralBank;
import bank.entities.client.Adult;
import bank.entities.client.Client;
import bank.entities.client.Student;
import bank.entities.loan.Loan;
import bank.entities.loan.MortgageLoan;
import bank.entities.loan.StudentLoan;
import bank.repositories.LoanRepository;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;

public class ControllerImpl implements Controller{

    private LoanRepository loans;

    private Collection<Bank> banks;

    public ControllerImpl(){
        this.loans = new LoanRepository();
        this.banks = new ArrayList<>();
    }

    @Override
    public String addBank(String type, String name) {
        Bank bank;
        if(type.equals("CentralBank")){
            bank = new CentralBank(name);
        }else if(type.equals("BranchBank")){
            bank = new BranchBank(name);
        }else {
            throw new IllegalArgumentException(ExceptionMessages
                    .INVALID_BANK_TYPE);
        }

        this.banks.add(bank);
        return String.format(ConstantMessages
                .SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String addLoan(String type) {
        Loan loan;
        if(type.equals("StudentLoan")){
            loan = new StudentLoan();
        }else if(type.equals("MortgageLoan")){
            loan = new MortgageLoan();
        }else {
            throw new IllegalArgumentException(ExceptionMessages
                    .INVALID_LOAN_TYPE);
        }

        this.loans.addLoan(loan);
        return String.format(ConstantMessages
                .SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String returnedLoan(String bankName, String loanType) {
        Bank bank = getBankByName(bankName);
        Loan loan = this.loans.findFirst(loanType);
        if(loan == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages
                    .NO_LOAN_FOUND, loanType));
        }
        this.loans.removeLoan(loan);
        bank.addLoan(loan);
        return String.format(ConstantMessages
                .SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, loanType, bankName);
    }

    private Bank getBankByName(String name){
        return this.banks.stream().filter(b ->
                        b.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {
        Client client;
        if(clientType.equals("Student")){
            client = new Student(clientName, clientID, income);
        }else if(clientType.equals("Adult")){
            client = new Adult(clientName, clientID, income);
        }else {
            throw new IllegalArgumentException(ExceptionMessages
                    .INVALID_CLIENT_TYPE);
        }
        Bank bank = getBankByName(bankName);
        try{
            bank.addClient(client);
        }catch (IllegalArgumentException e){
            return e.getMessage();
        }
        return String.format(ConstantMessages
                .SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, clientType, bankName);
    }

    @Override
    public String finalCalculation(String bankName) {
        Bank bank = getBankByName(bankName);
        double total = 0;
        for(Client client : bank.getClients()){
            total += client.getIncome();
        }
        for(Loan loan : bank.getLoans()){
            total += loan.getAmount();
        }

        return String.format(ConstantMessages
                .FUNDS_BANK, bankName, total);
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        this.banks.forEach(b -> output
                .append(b.getStatistics())
                .append(System.lineSeparator()));

        return output.toString().trim();
    }
}
