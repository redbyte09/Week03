package com.comparisionofbyteandcharacter;

import java.io.*;

public class ConsoleToFile {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\saksh\\OneDrive\\Desktop\\UserInput.txt"; // File path

        try {
            //  Create InputStreamReader to read from console
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // Create FileWriter to write to the file
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            System.out.println("Enter text (type 'exit' to stop):");

            //  Read user input and write to file
            String line;
            while (!(line = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                bufferedWriter.write(line);
                // Move to the next line in the file
                bufferedWriter.newLine();
            }
            bufferedReader.close();
            bufferedWriter.close();

            System.out.println("User input successfully saved to " + fileName);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

