package com.filehandling;

import java.io.*;
//create the class here
public class FileReaderCount {
    public static void main(String[] args) {
        //give our file location here
        String fileName="C:\\Users\\saksh\\OneDrive\\Desktop\\New.txt";
        //target element is this
        String target="This";
        //initialize word count with 0
        int wordCount=0;
        File file=new File(fileName);
        //checking if file exist
        if(file.exists() && file.length()>0){
            try{
                FileReader fileReader=new FileReader(fileName);
                BufferedReader buffer=new BufferedReader(fileReader);
                String line;
                while((line= buffer.readLine()) != null){
                    String[] count=line.split(" ");
                    for(int i=0;i<count.length;i++){
                        if(count[i].equals(target)){
                            wordCount++;
                        }
                    }
                }
                buffer.close();
                fileReader.close();
                System.out.println("The word '" + target + "' appears " + wordCount + " times in the file.");

            } catch (Exception e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
        else{
            System.out.println("The file " + fileName + " does not exist.");
        }
    }
}
