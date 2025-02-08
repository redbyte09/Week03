package com.filereadingperformance;
//import
import java.io.*;


public class FileReadingPerformance {

    // 8 KB buffer size for efficiency
    private static final int BUFFER_SIZE = 8192;


    public void readUsingFileReader(String filePath) {
        // Start time tracking
        long startTime = System.currentTimeMillis();

        try (FileReader reader = new FileReader(filePath)) {
            int character;
            // Reading character by character (very slow for large files)
            while ((character = reader.read()) != -1) {

            }
        } catch (IOException e) {
            System.out.println("Error reading file with FileReader: " + e.getMessage());
        }

        // End time tracking
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken using FileReader: " + (endTime - startTime) + "ms");
    }


    public void readUsingInputStreamReader(String filePath) {
        // Start time tracking
        long startTime = System.currentTimeMillis();

        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
            // Use buffer for efficiency
            char[] buffer = new char[BUFFER_SIZE];
            while (reader.read(buffer) != -1) {
                // Reading in chunks instead of character by character
            }
        } catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
        }

        long endTime = System.currentTimeMillis(); // End time tracking
        System.out.println("Time taken using InputStreamReader: " + (endTime - startTime) + "ms");
    }
}
