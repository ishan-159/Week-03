package stackandqueues.stockspan;

import java.util.Stack;

class StockSpan {

    //Method to calculate the stock span for each day
    public void calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];  // Array to store span values

        // Stack to store indices of the prices array
        Stack<Integer> stack = new Stack<>();

        // Traverse all stock prices
        for (int i = 0; i < n; i++) {
            // Pop elements from the stack while the current price is greater than the price at the top of the stack
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If the stack is empty, it means the current price is greater than all previous prices
            span[i] = (stack.isEmpty()) ? i + 1 : i - stack.peek();

            // Push the current index onto the stack
            stack.push(i);
        }

        // Print the calculated span values
        for (int i = 0; i < n; i++) {
            System.out.print(span[i] + " ");
        }
        System.out.println();
    }
}