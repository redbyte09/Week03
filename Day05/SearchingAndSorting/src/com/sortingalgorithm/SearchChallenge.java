package com.sortingalgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class SearchChallenge {

    // Function to find the first missing positive integer using Linear Search
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;

        // Mark numbers present in the array using an auxiliary array
        boolean[] present = new boolean[n + 1];

        for (int num : arr) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }

        // Find the first missing positive number
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }

        return n + 1;
    }

    // Function to perform Binary Search on a sorted array
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                // Search right half
                left = mid + 1;
            } else {
                // Search left half
                right = mid - 1;
            }
        }
        // Target not found
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for the array
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Find the first missing positive integer
        int missingNumber = findFirstMissingPositive(arr);
        System.out.println("First missing positive integer: " + missingNumber);

        // Sorting the array before performing Binary Search
        Arrays.sort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));

        // Take user input for the target value
        System.out.print("Enter the target number to search: ");
        int target = scanner.nextInt();

        // Perform Binary Search
        int targetIndex = binarySearch(arr, target);
        if (targetIndex != -1) {
            System.out.println("Target number found at index: " + targetIndex);
        } else {
            System.out.println("Target number not found.");
        }

        scanner.close();
    }
}

