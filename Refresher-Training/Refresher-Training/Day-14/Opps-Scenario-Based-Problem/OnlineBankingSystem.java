import java.util.*;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class Transaction {
    private String type;
    private double amount;
    private String description;

    public Transaction(String type, double amount, String description) {
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public String toString() {
        return type + " | Amount: " + amount + " | " + description;
    }
}

abstract class Account {
    protected String accountNumber;
    protected String holderName;
    protected double balance;

    private List<Transaction> transactions =
            Collections.synchronizedList(new ArrayList<>());

    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }

        balance += amount;

        transactions.add(
            new Transaction("DEPOSIT", amount, "Money deposited")
        );
    }

    public synchronized void withdraw(double amount)
            throws InsufficientBalanceException {

        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Insufficient balance in account " + accountNumber
            );
        }

        balance -= amount;

        transactions.add(
            new Transaction("WITHDRAW", amount, "Money withdrawn")
        );
    }

    public synchronized double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void showTransactions() {
        synchronized (transactions) {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    abstract double calculateInterest();
}

class SavingsAccount extends Account {

    private final double interestRate = 0.04;

    public SavingsAccount(
            String accountNumber,
            String holderName,
            double balance) {

        super(accountNumber, holderName, balance);
    }

    @Override
    double calculateInterest() {
        return balance * interestRate;
    }
}

class CurrentAccount extends Account {

    private final double interestRate = 0.01;

    public CurrentAccount(
            String accountNumber,
            String holderName,
            double balance) {

        super(accountNumber, holderName, balance);
    }

    @Override
    double calculateInterest() {
        return balance * interestRate;
    }
}

interface BankService {

    void createAccount(
            String accountNumber,
            String holderName,
            double initialBalance,
            String type);

    double checkBalance(String accountNumber);

    void transfer(
            String fromAccount,
            String toAccount,
            double amount)
            throws InsufficientBalanceException;

    void showTransactionHistory(String accountNumber);
}

class Bank implements BankService {

    private Map<String, Account> accounts =
            new HashMap<>();

    @Override
    public synchronized void createAccount(
            String accountNumber,
            String holderName,
            double initialBalance,
            String type) {

        if (accounts.containsKey(accountNumber)) {
            throw new IllegalArgumentException(
                "Account already exists"
            );
        }

        Account account;

        if (type.equalsIgnoreCase("SAVINGS")) {

            account = new SavingsAccount(
                accountNumber,
                holderName,
                initialBalance
            );

        } else if (type.equalsIgnoreCase("CURRENT")) {

            account = new CurrentAccount(
                accountNumber,
                holderName,
                initialBalance
            );

        } else {

            throw new IllegalArgumentException(
                "Invalid account type"
            );
        }

        accounts.put(accountNumber, account);

        System.out.println(
            "Account created: " + accountNumber
        );
    }

    @Override
    public double checkBalance(String accountNumber) {

        Account account = getAccount(accountNumber);

        return account.getBalance();
    }

    @Override
    public void transfer(
            String fromAccount,
            String toAccount,
            double amount)
            throws InsufficientBalanceException {

        Account sender = getAccount(fromAccount);
        Account receiver = getAccount(toAccount);

        if (sender == receiver) {
            throw new IllegalArgumentException(
                "Cannot transfer to same account"
            );
        }

        Account first;
        Account second;

        if (sender.getAccountNumber()
                .compareTo(receiver.getAccountNumber()) < 0) {

            first = sender;
            second = receiver;

        } else {

            first = receiver;
            second = sender;
        }

        synchronized (first) {

            synchronized (second) {

                sender.withdraw(amount);
                receiver.deposit(amount);

                System.out.println(
                    "Transferred " + amount +
                    " from " + fromAccount +
                    " to " + toAccount
                );
            }
        }
    }

    @Override
    public void showTransactionHistory(
            String accountNumber) {

        Account account = getAccount(accountNumber);

        System.out.println(
            "\nTransaction History: " + accountNumber
        );

        account.showTransactions();
    }

    private Account getAccount(String accountNumber) {

        Account account = accounts.get(accountNumber);

        if (account == null) {
            throw new IllegalArgumentException(
                "Account not found: " + accountNumber
            );
        }

        return account;
    }
}

public class OnlineBankingSystem {

    public static void main(String[] args) {

        BankService bank = new Bank();

        // Account creation
        bank.createAccount(
            "A101",
            "Bharat",
            50000,
            "SAVINGS"
        );

        bank.createAccount(
            "A102",
            "Rahul",
            30000,
            "CURRENT"
        );

        // Balance check
        System.out.println(
            "\nBharat Balance: " +
            bank.checkBalance("A101")
        );

        System.out.println(
            "Rahul Balance: " +
            bank.checkBalance("A102")
        );

        // Deposit
        Account testAccount =
            new SavingsAccount(
                "A103",
                "Test",
                10000
            );

        testAccount.deposit(5000);

        System.out.println(
            "\nTest Account Balance: " +
            testAccount.getBalance()
        );

        // Concurrent transfer 1
        Runnable transfer1 = () -> {

            try {

                bank.transfer(
                    "A101",
                    "A102",
                    5000
                );

            } catch (InsufficientBalanceException e) {

                System.out.println(e.getMessage());
            }
        };

        // Concurrent transfer 2
        Runnable transfer2 = () -> {

            try {

                bank.transfer(
                    "A102",
                    "A101",
                    2000
                );

            } catch (InsufficientBalanceException e) {

                System.out.println(e.getMessage());
            }
        };

        Thread t1 = new Thread(transfer1);
        Thread t2 = new Thread(transfer2);

        t1.start();
        t2.start();

        try {

            t1.join();
            t2.join();

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }

        // Final balances
        System.out.println(
            "\nFinal Bharat Balance: " +
            bank.checkBalance("A101")
        );

        System.out.println(
            "Final Rahul Balance: " +
            bank.checkBalance("A102")
        );

        // Transaction history
        bank.showTransactionHistory("A101");

        bank.showTransactionHistory("A102");

        // Polymorphism
        Account savings =
            new SavingsAccount(
                "S1",
                "User1",
                10000
            );

        Account current =
            new CurrentAccount(
                "C1",
                "User2",
                10000
            );

        System.out.println(
            "\nSavings Interest: " +
            savings.calculateInterest()
        );

        System.out.println(
            "Current Interest: " +
            current.calculateInterest()
        );
    }
}