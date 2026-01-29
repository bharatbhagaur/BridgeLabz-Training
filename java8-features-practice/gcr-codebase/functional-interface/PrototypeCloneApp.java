package functionalinterface;

//Prototype class implementing Cloneable marker interface
class ProductTemplate implements Cloneable {

 private int productId;
 private String productName;

 public ProductTemplate(int id, String name) {
     this.productId = id;
     this.productName = name;
 }

 // Method to create clone
 public ProductTemplate createCopy() {

     try {
         return (ProductTemplate) super.clone();
     } catch (CloneNotSupportedException e) {
         System.out.println("Cloning not supported");
         return null;
     }
 }

 public String getDetails() {
     return productId + " - " + productName;
 }
}

//Main class
public class PrototypeCloneApp {

 public static void main(String[] args) {

     ProductTemplate originalObject = new ProductTemplate(201, "Standard Model");

     ProductTemplate clonedObject = originalObject.createCopy();

     System.out.println("Original Object: " + originalObject.getDetails());
     System.out.println("Cloned Object: " + clonedObject.getDetails());
 }
}
