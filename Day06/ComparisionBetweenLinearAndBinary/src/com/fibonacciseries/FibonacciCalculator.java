package com.fibonacciseries;

//create class here
public class FibonacciCalculator {

    // Recursive Fibonacci
    public static int fibonacciRecursive(int n) {
        // Base case
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    //  Iterative Fibonacci
    public static int fibonacciIterative(int n) {
        // Base case
        if (n <= 1) return n;

        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}

