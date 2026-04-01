package bank;


public class Program {

    // Balance property
    public double Balance;

    // Constructor
    public Program(double initialBalance) {
        this.Balance = initialBalance;
    }

    // Deposit method
    public void Deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(
                "Deposit amount cannot be negative"
            );
        }
        Balance += amount;
    }

    // Withdraw method
    public void Withdraw(double amount) {
        if (amount > Balance) {
            throw new IllegalArgumentException(
                "Insufficient funds."
            );
        }
        Balance -= amount;
    }
}