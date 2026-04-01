package functionalinterface;

//Interface
interface Payment {
 void pay(double amount);
}

//UPI class
class UPI implements Payment {
 public void pay(double amount) {
     System.out.println("Payment of ₹" + amount + " done using UPI 📱");
 }
}

//Credit Card class
class CreditCard implements Payment {
 public void pay(double amount) {
     System.out.println("Payment of ₹" + amount + " done using Credit Card 💳");
 }
}

//Wallet class
class Wallet implements Payment {
 public void pay(double amount) {
     System.out.println("Payment of ₹" + amount + " done using Wallet 👛");
 }
}

//Main class
public class DigitalPayment {
 public static void main(String[] args) {

     Payment upi = new UPI();
     Payment card = new CreditCard();
     Payment wallet = new Wallet();

     upi.pay(500);
     card.pay(1200);
     wallet.pay(300);
 }
}
