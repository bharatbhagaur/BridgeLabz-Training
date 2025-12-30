import java.util.*;

interface Loanable {
    // apply for loan
    void applyForLoan();

    // check loan eligibility
    double calculateLoanEligibility();
}

abstract class BankAccount {
    // sensitive details are encapsulated
    private String accountNumber;
    private String holderName;
    private double balance;

    // constructor for common account details
    BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // controlled access to balance
    double getBalance() {
        return balance;
    }

    // deposit operation
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // withdrawal with balance check
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    // forces subclasses to define interest logic
    abstract double calculateInterest();
}

class SavingsAccount extends BankAccount implements Loanable {

    SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    // interest for savings account
    double calculateInterest() {
        return getBalance() * 0.04;
    }

    public void applyForLoan() {
        System.out.println("Loan applied for Savings Account");
    }

    public double calculateLoanEligibility() {
        return getBalance() * 2;
    }
}

class CurrentAccount extends BankAccount implements Loanable {

    CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    // interest for current account
    double calculateInterest() {
        return getBalance() * 0.02;
    }

    public void applyForLoan() {
        System.out.println("Loan applied for Current Account");
    }

    public double calculateLoanEligibility() {
        return getBalance() * 1.5;
    }
}

public class BankingSystem {

    // polymorphic processing of accounts
    static void processAccount(BankAccount acc) {

        System.out.println("Balance: " + acc.getBalance());
        System.out.println("Interest: " + acc.calculateInterest());

        if (acc instanceof Loanable) {
            ((Loanable) acc).applyForLoan();
            System.out.println("Loan Eligibility: " + ((Loanable) acc).calculateLoanEligibility());
        }

        System.out.println();
    }

    public static void main(String[] args) {

        ArrayList<BankAccount> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("SA101", "Rahul", 50000));
        accounts.add(new CurrentAccount("CA202", "Amit", 80000));

        for (BankAccount acc : accounts) {
            processAccount(acc);
        }
    }
}