package com.stackquestions;

import java.util.Stack;

class StockSpan {

    // Function to calculate stock span for each day
    public static int[] calculateSpan(int prices[]) {
        int n = prices.length;
        // Array to store span values
        int span[] = new int[n];
        // Stack to store indices
        Stack<Integer> stack = new Stack<>();

        // Process each price
        for (int i = 0; i < n; i++) {
            // Pop elements from stack while stack is not empty and price at top of stack is <= current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, it means no previous higher price, span = i + 1
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

            // Push current index to stack
            stack.push(i);
        }
        return span;
    }

    // Driver code to test the function
    public static void main(String[] args) {
        int prices[] = {100, 80, 60, 70, 60, 75, 85};
        int span[] = calculateSpan(prices);

        // Print the spans
        System.out.println("Stock Spans: ");
        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}

