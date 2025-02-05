package com.searchingalgorithm;

import java.util.Scanner;

class FirstNegativeSearch {
    public static int findFirstNegative(int[] arr) {
        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Check if the element is negative
            if (arr[i] < 0) {
                // Return index if a negative number is found
                return i;
            }
        }
        // Return -1 if no negative number is found
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //take user input for size of array
        System.out.println("Enter the size of the array");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        int result = findFirstNegative(arr);
        System.out.println("Index of first negative number: " + result);
    }
}

