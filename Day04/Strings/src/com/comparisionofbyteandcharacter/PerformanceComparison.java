package com.comparisionofbyteandcharacter;

import java.io.*;

public class PerformanceComparison {
    public static void main(String[] args) {
        compareStringBuilderAndBuffer();
        compareFileReaders("C:\\Users\\saksh\\OneDrive\\Desktop\\LargeFile.txt");
    }

    // Compare StringBuilder vs StringBuffer Performance
    public static void compareStringBuilderAndBuffer() {
        String text = "hello";

        // 🔹 Measure StringBuilder time
        long startSB = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1_000_000; i++) {
            sb.append(text);
        }
        long endSB = System.nanoTime();
        System.out.println("Time taken by StringBuilder: " + (endSB - startSB) / 1_000_000 + " ms");

        // Measure StringBuffer time
        long startSBf = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < 1_000_000; i++) {
            sbf.append(text);
        }
        long endSBf = System.nanoTime();
        System.out.println("Time taken by StringBuffer: " + (endSBf - startSBf) / 1_000_000 + " ms");
    }

    // 2Compare FileReader vs InputStreamReader Performance
    public static void compareFileReaders(String filePath) {
        long wordCountFR = countWordsUsingFileReader(filePath);
        long wordCountISR = countWordsUsingInputStreamReader(filePath);

        System.out.println("Total words in file using FileReader: " + wordCountFR);
        System.out.println("Total words in file using InputStreamReader: " + wordCountISR);
    }

    // Read file using FileReader and count words
    public static long countWordsUsingFileReader(String filePath) {
        long start = System.nanoTime();
        long wordCount = 0;

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        long end = System.nanoTime();
        System.out.println("Time taken by FileReader: " + (end - start) / 1_000_000 + " ms");
        return wordCount;
    }

    // 🔹 Read file using InputStreamReader and count words
    public static long countWordsUsingInputStreamReader(String filePath) {
        long start = System.nanoTime();
        long wordCount = 0;

        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        long end = System.nanoTime();
        System.out.println("Time taken by InputStreamReader: " + (end - start) / 1_000_000 + " ms");
        return wordCount;
    }
}

