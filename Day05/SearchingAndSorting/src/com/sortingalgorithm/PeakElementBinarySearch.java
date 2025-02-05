package com.sortingalgorithm;

import java.util.Scanner;

public class PeakElementBinarySearch {
    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid + 1]) {
                // Peak is in the left half
                right = mid;
            } else {
                // Peak is in the right half
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for array size
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Finding the peak element
        int peakIndex = findPeakElement(arr);
        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element: " + arr[peakIndex]);

        scanner.close();
    }
}
