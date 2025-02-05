package com.filehandling;
//import java.io.pakage because file classes are in it
import java.io.*;
//create FileReaderExample class
public class FileReaderExample {
    public static void main(String[] args) {
        //giving my directory path link
        String fileName = "C:\\Users\\saksh\\OneDrive\\Desktop\\New.txt";
       // using try catch block here
        try {
            //fileReader and BufferReader is used for reading file
            FileReader file = new FileReader(fileName);
            BufferedReader bufferFile = new BufferedReader(file);

            try {
                String line;
                //checking if our file is empty 0r not
                while ((line = bufferFile.readLine()) != null) {
                    System.out.println(line);
                }
                //use catch exception here
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            } finally {
                //closing
                bufferFile.close();
                file.close();
            }

        } catch (IOException e) {
            System.out.println("Error opening file: " + e.getMessage());
        }
    }
}
