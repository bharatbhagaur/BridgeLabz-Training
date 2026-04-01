package streamapi;

import java.util.*;

public class StockPriceLogger {
    public static void main(String[] args) {

        List<Double> stockPrices = Arrays.asList(
            2450.50, 2460.75, 2448.30, 2475.90, 2468.10
        );

        stockPrices.stream()
                   .forEach(price ->
                       System.out.println("Stock Price Update: ₹" + price)
                   );
    }
}
