package com.sortingalgorithm;

import java.util.Scanner;

public class FirstAndLastOccurrence {
    public static int findFirstOccurrence(int[] arr, int target) {
        //initializing value
        int left = 0, right = arr.length - 1, first = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                // Store index and search left
                first = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return first;
    }

    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, last = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                // Store index and search right
                last = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return last;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for array size
        System.out.print("Enter the number of elements in the sorted array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Taking user input for target value
        System.out.print("Enter the target value to search: ");
        int target = scanner.nextInt();

        // Finding first and last occurrence
        int firstIndex = findFirstOccurrence(arr, target);
        int lastIndex = findLastOccurrence(arr, target);

        // Displaying the result
        if (firstIndex == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("First occurrence index: " + firstIndex);
            System.out.println("Last occurrence index: " + lastIndex);
        }

        scanner.close();
    }
}
