package com.linaerandbinary;
//import
import java.util.Random;
import java.util.Scanner;
public class OneThousandTestCase {
    public static void main(String[] args) {


        Random random = new Random();
        //create object here
        LinerSearchAndBinarySearch lsbs=new LinerSearchAndBinarySearch();
        //size of random generated array is 1000
        int arr[]=lsbs.randomArray(1000);


         //random generate target element here
        int ran=random.nextInt();
        //take starting time
        long start=System.nanoTime();

        //call linearSearch method here
        lsbs.linerSearch(arr,ran);
        //take ending time here
        long end=System.nanoTime();

        System.out.println(end-start);

        long start1=System.nanoTime();
        //call binarySearch method here
        lsbs.binarySearch(arr,ran);

        long end1=System.nanoTime();
        System.out.println(end1-start1);


    }
}
