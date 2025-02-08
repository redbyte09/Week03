package com.sortingalgorithms;

import java.util.Random;
import java.util.Arrays;

public class SortingAlgorithms {

    // Generate a random array of size n
    public int[] randomArray(int n) {
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n);
        }
        return arr;
    }

    // Bubble Sort Algorithm
    public void bubbleSort(int[] arr) {
        int temp;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break; // If no swaps, array is already sorted
            }
        }

        System.out.println("Sorted array using Bubble Sort: " + Arrays.toString(arr));
    }

    // Merge Sort Algorithm
    public void mergeSort(int[] arr) {
        divide(arr, 0, arr.length - 1);
        System.out.println("Sorted array using Merge Sort: " + Arrays.toString(arr));
    }

    private void divide(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;
        divide(arr, si, mid);
        divide(arr, mid + 1, ei);
        conquer(arr, si, ei, mid);
    }

    private void conquer(int arr[], int si, int ei, int mid) {
        int[] merged = new int[ei - si + 1];
        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;

        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2++];
            }
        }

        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }

        while (idx2 <= ei) {
            merged[x++] = arr[idx2++];
        }

        // Copy sorted elements back to original array
        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    // Quick Sort Algorithm
    public void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
        System.out.println("Sorted array using Quick Sort: " + Arrays.toString(arr));
    }

    private void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {  // Correct base condition to prevent infinite recursion
            int pidx = partition(arr, low, high);

            // Ensure recursive calls only happen when subarray size reduces
            if (pidx - 1 > low) {
                quickSortHelper(arr, low, pidx - 1);
            }
            if (pidx + 1 < high) {
                quickSortHelper(arr, pidx + 1, high);
            }
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choosing last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
