package functionalinterface;

interface PaymentProcessor {

    void processPayment(double amount);

    // Default method added without breaking existing implementations
    default void refund(double amount) {
        System.out.println("Refund processed for amount: " + amount);
    }
}

class BankTransferProcessor implements PaymentProcessor {

    public void processPayment(double amount) {
        System.out.println("Bank transfer payment processed for amount: " + amount);
    }
}

class CardPaymentProcessor implements PaymentProcessor {

    public void processPayment(double amount) {
        System.out.println("Card payment processed for amount: " + amount);
    }

    // Optional override of default method
    public void refund(double amount) {
        System.out.println("Card refund completed for amount: " + amount);
    }
}

public class PaymentGatewayApp {

    public static void main(String[] args) {

        PaymentProcessor bank = new BankTransferProcessor();
        PaymentProcessor card = new CardPaymentProcessor();

        bank.processPayment(5000);
        bank.refund(1000);

        card.processPayment(2500);
        card.refund(500);
    }
}
