package com.sortingalgorthms;


import java.util.Scanner;


public class MergeSort {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //user for the number of book prices
        System.out.print("Enter the number of book prices: ");
        int n = scanner.nextInt();


        // Create an array to store the book prices
        double[] prices = new double[n];


        //  user to enter each book price
        System.out.println("Enter the book prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextDouble();
        }


        // Start with dividing the array from the whole
        for (int size = 1; size < n; size = size * 2) {
            for (int left = 0; left < n - 1; left += 2 * size) {
                // Find the middle and right indices
                int middle = Math.min(n - 1, left + size - 1);
                int right = Math.min(n - 1, left + 2 * size - 1);


                // Merge the subarrays from left to middle and middle+1 to right
                int n1 = middle - left + 1;
                int n2 = right - middle;


                // Create temporary arrays for left and right subarrays
                double[] leftArr = new double[n1];
                double[] rightArr = new double[n2];


                // Copy the data to temporary arrays
                System.arraycopy(prices, left, leftArr, 0, n1);
                System.arraycopy(prices, middle + 1, rightArr, 0, n2);


                // Merging the temporary arrays back into the original array
                int i = 0, j = 0, k = left;
                while (i < n1 && j < n2) {
                    if (leftArr[i] <= rightArr[j]) {
                        prices[k] = leftArr[i];
                        i++;
                    } else {
                        prices[k] = rightArr[j];
                        j++;
                    }
                    k++;
                }


                // Copy the remaining elements of leftArr[] if any
                while (i < n1) {
                    prices[k] = leftArr[i];
                    i++;
                    k++;
                }


                // Copy the remaining elements of rightArr[] if any
                while (j < n2) {
                    prices[k] = rightArr[j];
                    j++;
                    k++;
                }
            }
        }


        // Print the sorted book prices
        System.out.println("Sorted Book Prices:");
        for (double price : prices) {
            System.out.print(price + " ");
        }
        scanner.close();
    }
}
