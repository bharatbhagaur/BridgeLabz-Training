import java.util.*;

class Order {
    int orderId;
    String orderDate;

    // constructor for base Order class
    Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    // method to return order status
    String getOrderStatus() {
        return "Order Placed";
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    // constructor for ShippedOrder
    ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    // overridden method for shipped order status
    String getOrderStatus() {
        return "Order Shipped";
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    // constructor for DeliveredOrder
    DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    // overridden method for delivered order status
    String getOrderStatus() {
        return "Order Delivered";
    }
}

public class OnlineRetailOrderManagement {
    public static void main(String[] args) {
        // creating DeliveredOrder object
        DeliveredOrder order = new DeliveredOrder(1001, "25-12-2025", "TRK12345", "28-12-2025");

        // displaying order details
        System.out.println("Order ID: " + order.orderId);
        System.out.println("Order Date: " + order.orderDate);
        System.out.println("Tracking Number: " + order.trackingNumber);
        System.out.println("Delivery Date: " + order.deliveryDate);
        System.out.println("Order Status: " + order.getOrderStatus());
    }
}
