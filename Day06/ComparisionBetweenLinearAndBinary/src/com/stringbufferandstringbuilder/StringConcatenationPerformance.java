package com.stringbufferandstringbuilder;

public class StringConcatenation {

        public void concatenateStrings(int n) {
            //start time tracking
            long startTime = System.currentTimeMillis();
           //empty string initialization
            String str = "";
            for (int i = 0; i < n; i++) {
                str += "a";
            }
            // End time tracking
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken using String: " + (endTime - startTime) + "ms");
        }
    }


