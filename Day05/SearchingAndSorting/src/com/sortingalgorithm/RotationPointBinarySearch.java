package com.sortingalgorithm;

import java.util.Scanner;

public class RotationPointBinarySearch {
    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            // Calculate mid to avoid overflow
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                // Smallest element is in the right half
                left = mid + 1;
            } else {
                // Smallest element is in the left half (including mid)
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for the array size
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the rotated sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Finding the rotation point
        int rotationIndex = findRotationPoint(arr);
        System.out.println("Rotation point index: " + rotationIndex);
        System.out.println("Smallest element: " + arr[rotationIndex]);

        scanner.close();
    }
}
