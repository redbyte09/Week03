package com.sortingalgorithms;

import java.util.Random;

public class TenThounsandTestCase {
    public static void main(String[] args) {


        Random random = new Random();
        //create object here
        SortingAlgorithms s=new SortingAlgorithms();
        //size of random generated array is 10000
        int arr[]=s.randomArray(10000);


        //random generate target element here
        int ran=random.nextInt();
        //take starting time
        long start=System.nanoTime();

        //call bubbleSort method here
        s.bubbleSort(arr);
        //take ending time here
        long end=System.nanoTime();

        System.out.println(end-start);

        long start1=System.nanoTime();
        //call mergeSort method here
        s.mergeSort(arr);

        long end1=System.nanoTime();
        System.out.println(end1-start1);

        //take starting time
        long start2=System.nanoTime();
        //call mergeSort method here
        s.quickSort(arr);
        //take ending time here
        long end2=System.nanoTime();

        System.out.println(end2-start2);






    }
}
