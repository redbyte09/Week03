package com.stringbufferandstringbuilder;

public class TenThousandTestCase {
    public static void main(String[] args) {
        int n = 100000;

        System.out.println("Starting Performance Comparison...");

        // Create an instance of t class
        StringConcatenationPerformance tester = new StringConcatenationPerformance();

        // Test String Concatenation
        tester.concatenateUsingString(n);

        // Test StringBuilder Concatenation
        tester.concatenateUsingStringBuilder(n);

        // Test StringBuffer Concatenation
        tester.concatenateUsingStringBuffer(n);
    }
}
