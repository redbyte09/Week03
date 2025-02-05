package com.searchingalgorithm;

import java.util.Scanner;

public class WordSearchInSentences {
    public static String findSentenceWithWord(String[] sentences, String word) {
        // Iterate through the list of sentences
        for (String sentence : sentences) {
            // Check if the sentence contains the word
            if (sentence.contains(word)) {
                // Return the sentence if found
                return sentence;
            }
        }
        // Return "Not Found" if no sentence contains the word
        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for the number of sentences
        System.out.print("Enter the number of sentences: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        // Taking user input for sentences
        String[] sentences = new String[n];
        System.out.println("Enter the sentences:");
        for (int i = 0; i < n; i++) {
            sentences[i] = scanner.nextLine();
        }

        // Taking user input for the word to search
        System.out.print("Enter the word to search: ");
        String word = scanner.nextLine();

        // Searching for the word in sentences
        String result = findSentenceWithWord(sentences, word);
        System.out.println("Sentence containing the word: " + result);

        scanner.close();
    }
}

