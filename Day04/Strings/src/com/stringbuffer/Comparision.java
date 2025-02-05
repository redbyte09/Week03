package com.stringbuffer;

public class Comparision {
    public static void main(String[] args) {
        // Measuring time for StringBuffer
        StringBuffer sb = new StringBuffer("Asarsh");
        long start1 = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            sb.append("is");
        }
        long end1 = System.nanoTime();
        long time1 = end1 - start1;
        System.out.println("Time taken by StringBuffer: " + time1 + " nanoseconds");

        // Measuring time for StringBuilder
        StringBuilder sbd = new StringBuilder("Sakshi");
        long start2 = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            sbd.append("is");
        }
        long end2 = System.nanoTime();
        long time2 = end2 - start2;
        System.out.println("Time taken by StringBuilder: " + time2 + " nanoseconds");
    }
}
