package com.stringbuffer;

import java.util.Scanner;
//create a class here
public class ArrayOfString {
    public static void main(String[] args) {
        //taking user input here
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of strings");
        //taking input for number of string
        int n=sc.nextInt();
        sc.nextLine();
        //create array of strings
        String[] str=new String[n];
        //create stringbuffer here
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<n;i++){
            //taking user input for strings
          str[i] =sc.nextLine();
          //append string in stringbuffer
          sb.append(str[i]).append(" ");
        }
        System.out.println(sb.toString());

    }
}
