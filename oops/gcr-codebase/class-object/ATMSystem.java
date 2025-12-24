import java.util.Scanner;

class Account {

    String holderName;
    long accNo;
    double accBalance;

    // add money to account
    void addAmount(double money) {
        if (money > 0) {
            accBalance = accBalance + money;
            System.out.println("Deposit completed.");
        } else {
            System.out.println("Enter a valid amount.");
        }
    }

    // remove money from account
    void removeAmount(double money) {
        if (money <= 0) {
            System.out.println("Invalid amount entered.");
        } else if (money > accBalance) {
            System.out.println("Not enough balance.");
        } else {
            accBalance = accBalance - money;
            System.out.println("Withdrawal successful.");
        }
    }

    // show balance
    void showBalance() {
        System.out.println("Available Balance: " + accBalance);
    }
}

public class ATMSystem {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Account userAccount = new Account();

        System.out.print("Enter name: ");
        userAccount.holderName = input.nextLine();

        System.out.print("Enter account number: ");
        userAccount.accNo = input.nextLong();

        System.out.print("Enter starting balance: ");
        userAccount.accBalance = input.nextDouble();

        System.out.println("\n1. Add Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. View Balance");
        System.out.print("Select option: ");
        int option = input.nextInt();

        switch (option) {
            case 1:
                System.out.print("Enter deposit amount: ");
                userAccount.addAmount(input.nextDouble());
                break;

            case 2:
                System.out.print("Enter withdrawal amount: ");
                userAccount.removeAmount(input.nextDouble());
                break;

            case 3:
                userAccount.showBalance();
                break;

            default:
                System.out.println("Wrong option selected.");
        }

        userAccount.showBalance();
        input.close();
    }
}
