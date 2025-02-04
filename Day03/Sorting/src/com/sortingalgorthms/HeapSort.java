package com.sortingalgorthms;


import java.util.Scanner;


public class HeapSort {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of job applicants: ");
        int n = scanner.nextInt();


        // Create an array to store the salary demands
        int[] salaries = new int[n];
        System.out.println("Enter the expected salary demands:");
        for (int i = 0; i < n; i++) {
            salaries[i] = scanner.nextInt();
        }
        // Build a Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            int parent = i;
            while (parent < n / 2) {
                int leftChild = 2 * parent + 1;
                int rightChild = 2 * parent + 2;
                int largest = parent;


                if (leftChild < n && salaries[leftChild] > salaries[largest]) {
                    largest = leftChild;
                }


                if (rightChild < n && salaries[rightChild] > salaries[largest]) {
                    largest = rightChild;
                }


                if (largest == parent) {
                    break;
                }


                // Swap salaries[parent] and salaries[largest]
                int temp = salaries[parent];
                salaries[parent] = salaries[largest];
                salaries[largest] = temp;


                parent = largest;
            }
        }


        //  Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap the root (maximum element) with the last element
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;


            // Reheapify the reduced heap
            int parent = 0;
            while (parent < i) {
                int leftChild = 2 * parent + 1;
                int rightChild = 2 * parent + 2;
                int largest = parent;


                if (leftChild < i && salaries[leftChild] > salaries[largest]) {
                    largest = leftChild;
                }


                if (rightChild < i && salaries[rightChild] > salaries[largest]) {
                    largest = rightChild;
                }


                if (largest == parent) {
                    break;
                }
                int temp2 = salaries[parent];
                salaries[parent] = salaries[largest];
                salaries[largest] = temp2;


                parent = largest;
            }
        }


        // Print the sorted salaries
        System.out.println("Sorted Job Applicants by Salary:");
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }
        scanner.close();
    }
}
