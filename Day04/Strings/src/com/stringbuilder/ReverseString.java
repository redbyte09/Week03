package com.stringbuilder;

import java.util.Scanner;
//create a class ReverseString
public class ReverseString {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str="Hello";
        //using stringbuilder here and creating it's object and passing string in it
        StringBuilder s=new StringBuilder(str);

        System.out.println("Reverse String is:"+s.reverse());
    }

}
