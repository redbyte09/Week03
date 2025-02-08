package com.stringbufferandstringbuilder;

//create class here
public class StringConcatenationPerformance {

    //create method here
    public void concatenateUsingString(int n) {
        // Start time tracking
        long startTime = System.currentTimeMillis();

        // Empty string initialization
        String str = "";
        for (int i = 0; i < n; i++) {

            // Each iteration creates a new String object
            str += "a";
        }

        // End time tracking
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken using String: " + (endTime - startTime) + "ms");
    }

    //create a method here
    public void concatenateUsingStringBuilder(int n) {
        // Start time tracking
        long startTime = System.currentTimeMillis();

        // StringBuilder for fast concatenation
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // Append operation modifies the existing object
            sb.append("a");
        }

        // End time tracking
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken using StringBuilder: " + (endTime - startTime) + "ms");
    }


    public void concatenateUsingStringBuffer(int n) {
        // Start time tracking
        long startTime = System.currentTimeMillis();

        // StringBuffer for thread-safe operations
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }

        // End time tracking
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken using StringBuffer: " + (endTime - startTime) + "ms");
    }
}



