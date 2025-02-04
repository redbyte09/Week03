package com.sortingalgorthms;


import java.util.Scanner;


public class CountingSort {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();


        // Create an array to store the ages of students
        int[] ages = new int[n];
        System.out.println("Enter the students' ages (ranging from 10 to 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextInt();
        }
        int range = 9;


        // Create a count array to store the frequency of each age
        // Array to count frequencies of ages from 10 to 18
        int[] count = new int[range + 1];


        // Fill the count array with frequencies
        for (int i = 0; i < n; i++) {
            count[ages[i] - 10]++;
        }


        // Compute frequencies to determine positions
        for (int i = 1; i <= range; i++) {
            count[i] += count[i - 1];
        }


        //  Build the output array by placing elements in their correct positions
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[ages[i] - 10] - 1] = ages[i];
            // Decrease the count for that age
            count[ages[i] - 10]--;
        }


        // Copy the sorted array back to the original array
        for (int i = 0; i < n; i++) {
            ages[i] = output[i];
        }


        // Print the sorted ages
        System.out.println("Sorted Student Ages:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
        scanner.close();
    }
}



