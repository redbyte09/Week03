package com.comparisionofbyteandcharacter;

import java.io.*;

public class ByteToCharacterStream {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\saksh\\OneDrive\\Desktop\\New.txt";

        try {
            //  Read bytes from the file
            FileInputStream fileStream = new FileInputStream(fileName);

            //  Convert bytes to characters
            InputStreamReader inputStreamReader = new InputStreamReader(fileStream);

            //  Use BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // Read and print file content
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Close r
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
