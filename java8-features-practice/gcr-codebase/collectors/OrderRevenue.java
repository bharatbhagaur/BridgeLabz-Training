package collectors;

import java.util.*;
import java.util.stream.Collectors;
class Order {
    String customerName;
    double orderAmount;

    Order(String customerName, double orderAmount) {
        this.customerName = customerName;
        this.orderAmount = orderAmount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getOrderAmount() {
        return orderAmount;
    }
}

public class OrderRevenue {
    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
            new Order("Amit", 2500.50),
            new Order("Neha", 1800.00),
            new Order("Amit", 3200.75),
            new Order("Ravi", 1500.00),
            new Order("Neha", 2200.25)
        );

        Map<String, Double> revenuePerCustomer =
            orders.stream()
                  .collect(Collectors.groupingBy(
                      Order::getCustomerName,
                      Collectors.summingDouble(Order::getOrderAmount)
                  ));

        revenuePerCustomer.forEach((customer, total) ->
            System.out.println(customer + " → Total Revenue: ₹" + total)
        );
    }
}
