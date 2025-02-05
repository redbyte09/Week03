package com.stringbuilder;
import java.util.HashSet;
import java.util.Scanner;
//create a class here
public class DuplicateInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //taking user input here
        System.out.println("Enter a string");
        String s=sc.nextLine();
        //create stringbuilder here
        StringBuilder str=new StringBuilder(s);
        //creat hashset here
        HashSet<Character>hs=new HashSet<>();
        for(int i=0;i<s.length();i++){
            hs.add(s.charAt(i));
        }
        System.out.println(hs);
    }
}
