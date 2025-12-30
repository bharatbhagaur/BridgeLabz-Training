import java.util.*;

class Bank {
    String bankName;

    // constructor to initialize bank name
    Bank(String bankName) {
        this.bankName = bankName;
    }

    // method to open an account for a customer
    void openAccount(Customer c, double initialBalance) {
        c.balance = initialBalance;
        c.bank = this;
        System.out.println("Account opened for " + c.name + " in " + bankName);
    }
}

class Customer {
    String name;
    double balance;
    Bank bank; // association: customer is linked to a bank

    // constructor to initialize customer name
    Customer(String name) {
        this.name = name;
    }

    // method to view balance
    void viewBalance() {
        if (bank != null) {
            System.out.println("Customer Name: " + name);
            System.out.println("Bank: " + bank.bankName);
            System.out.println("Balance: " + balance);
        } else {
            System.out.println("No bank account linked.");
        }
    }
}

public class BankAndAccountAssociation {
    public static void main(String[] args) {
        // creating bank object
        Bank bank = new Bank("State Bank");

        // creating customer objects
        Customer c1 = new Customer("Amit");
        Customer c2 = new Customer("Neha");

        // opening accounts for customers
        bank.openAccount(c1, 50000);
        bank.openAccount(c2, 75000);

        System.out.println();

        // customers viewing their balance
        c1.viewBalance();
        System.out.println();
        c2.viewBalance();
    }
}