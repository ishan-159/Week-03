package stackandqueues.stockspan;

public class Main {
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        StockSpan stockSpan = new StockSpan();

        System.out.println("Stock spans for the given prices:");
        stockSpan.calculateSpan(prices);  // Output the stock spans for the given prices
    }

}
