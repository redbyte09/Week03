package com.fibonacciseries;

public class TestCaseFor30 {
    public static void main(String[] args) {
        int n = 30;
       //start time here
        long startRecursive = System.currentTimeMillis();
        //recursive call here
        int recursiveResult = FibonacciCalculator.fibonacciRecursive(n);
        //end time here
        long endRecursive = System.currentTimeMillis();
        //printing results here
        System.out.println("Recursive Fibonacci (" + n + "): " + recursiveResult);
        System.out.println("Time Taken (Recursive): " + (endRecursive - startRecursive) + "ms");

        //start time here
        long startIterative = System.currentTimeMillis();

        int iterativeResult = FibonacciCalculator.fibonacciIterative(n);
        //end time here
        long endIterative = System.currentTimeMillis();
        //print the results here
        System.out.println("Iterative Fibonacci (" + n + "): " + iterativeResult);
        System.out.println("Time Taken (Iterative): " + (endIterative - startIterative) + "ms");
    }

}
