package com.sortingalgorthms;


import java.util.Scanner;


public class QuickSort {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of product prices: ");
        int n = scanner.nextInt();


        // Create an array to store the product prices
        double[] prices = new double[n];
        System.out.println("Enter the product prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextDouble();
        }
        int low = 0;
        int high = n - 1;
        while (low < high) {
            // Choose the pivot (last element)
            double pivot = prices[high];
            int i = low - 1;


            // Partitioning step
            for (int j = low; j < high; j++) {
                if (prices[j] <= pivot) {
                    i++;
                    // Swap prices[i] and prices[j]
                    double temp = prices[i];
                    prices[i] = prices[j];
                    prices[j] = temp;
                }
            }


            // Swap the pivot element to the correct position
            double temp = prices[i + 1];
            prices[i + 1] = prices[high];
            prices[high] = temp;


            // Pivot is now at i + 1
            int pivotIndex = i + 1;


            // Sort the left partition (low to pivotIndex - 1)
            int left = low;
            int right = pivotIndex - 1;
            while (left < right) {
                double leftPivot = prices[right];
                int leftI = left - 1;
                for (int leftJ = left; leftJ < right; leftJ++) {
                    if (prices[leftJ] <= leftPivot) {
                        leftI++;
                        double leftTemp = prices[leftI];
                        prices[leftI] = prices[leftJ];
                        prices[leftJ] = leftTemp;
                    }
                }


                double leftTemp = prices[leftI + 1];
                prices[leftI + 1] = prices[right];
                prices[right] = leftTemp;


                left = leftI + 1;
            }


            // Sort the right partition (pivotIndex + 1 to high)
            int rightLeft = pivotIndex + 1;
            int rightHigh = high;
            while (rightLeft < rightHigh) {
                double rightPivot = prices[rightHigh];
                int rightI = rightLeft - 1;
                for (int rightJ = rightLeft; rightJ < rightHigh; rightJ++) {
                    if (prices[rightJ] <= rightPivot) {
                        rightI++;
                        double rightTemp = prices[rightI];
                        prices[rightI] = prices[rightJ];
                        prices[rightJ] = rightTemp;
                    }
                }


                double rightTemp = prices[rightI + 1];
                prices[rightI + 1] = prices[rightHigh];
                prices[rightHigh] = rightTemp;


                rightLeft = rightI + 1;
            }
            high = pivotIndex - 1;
        }


        // Print the sorted product prices
        System.out.println("Sorted Product Prices:");
        for (double price : prices) {
            System.out.print(price + " ");
        }
        scanner.close();
    }
}
