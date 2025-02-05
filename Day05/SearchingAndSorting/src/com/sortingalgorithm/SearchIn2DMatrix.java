package com.sortingalgorithm;

import java.util.Scanner;


public class SearchIn2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Convert mid to row & col index
            int midElement = matrix[mid / cols][mid % cols];

            if (midElement == target) {
                // Target found
                return true;
            } else if (midElement < target) {
                // Search right half
                left = mid + 1;
            } else {
                // Search left half
                right = mid - 1;
            }
        }// Target not found
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for matrix dimensions
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Enter elements of the matrix (row-wise sorted):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Taking user input for target value
        System.out.print("Enter target value to search: ");
        int target = scanner.nextInt();

        // Searching the matrix
        boolean found = searchMatrix(matrix, target);
        System.out.println("Target found: " + found);

        scanner.close();
    }
}
