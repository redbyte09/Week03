package com.sortingalgorthms;
//import scanner
import java.util.Scanner;


public class InsertionSort {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // Ask the user for the number of employee IDs
        System.out.print("Enter the number of employee IDs: ");
        int n = scanner.nextInt();


        // Create an array to store the employee IDs
        int[] employeeIDs = new int[n];


        // Ask the user to enter each employee ID
        System.out.println("Enter the employee IDs:");
        for (int i = 0; i < n; i++) {
            employeeIDs[i] = scanner.nextInt();
        }
        // Loop through the array starting from the second element
        for (int i = 1; i < employeeIDs.length; i++) {
            // Store the current element to be inserted
            int currentID = employeeIDs[i];


            // Start comparing the current element with elements in the sorted part
            int j = i - 1;
            while (j >= 0 && employeeIDs[j] > currentID) {
                employeeIDs[j + 1] = employeeIDs[j];
                j--;
            }


            // Insert the current element in its correct position
            employeeIDs[j + 1] = currentID;
        }


        // Print the sorted employee IDs
        System.out.println("Sorted Employee IDs:");
        for (int id : employeeIDs) {
            System.out.print(id + " ");
        }
        scanner.close();
    }
}
