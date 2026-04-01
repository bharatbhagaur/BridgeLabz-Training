import java.util.*;

class BankAccount {
    // static variable shared by all accounts
    static String bankName = "National Bank";
    static int totalAccounts = 0;

    String accountHolderName;
    final long accountNumber; // final: cannot be changed once assigned
    double balance;

    // constructor using this keyword to resolve ambiguity
    BankAccount(String accountHolderName, long accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }

    // static method to display total accounts
    static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    // instance method to display account details
    void displayDetails() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Rohit", 1234567890L, 50000);
        BankAccount acc2 = new BankAccount("Neha", 9876543210L, 75000);

        // instanceof check before displaying details
        if (acc1 instanceof BankAccount) {
            acc1.displayDetails();
        }

        System.out.println();

        if (acc2 instanceof BankAccount) {
            acc2.displayDetails();
        }

        System.out.println();
        BankAccount.getTotalAccounts(); // static method call
    }
}