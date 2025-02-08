package com.filereadingperformance;

public class TestCaseFor500MB {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\saksh\\OneDrive\\Desktop\\New.txt";

        System.out.println("Starting File Reading Performance Comparison...\n");

        // Create an instance of the performance class
        FileReadingPerformance tester = new FileReadingPerformance();

        // Test FileReader
        tester.readUsingFileReader(filePath);

        // Test InputStreamReader
        tester.readUsingInputStreamReader(filePath);
    }
}
