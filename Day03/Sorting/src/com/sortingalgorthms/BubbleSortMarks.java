package com.sortingalgorthms;


// Import Scanner
import java.util.Scanner;


public class BubbleSortMarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //  Take input for the number of students
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();


        // Create an array to store student marks
        int[] marks = new int[n];


        // Take input for student marks
        System.out.println("Enter the marks of students:");
        for (int i = 0; i < n; i++) {
            marks[i] = scanner.nextInt();
        }


        // Bubble Sort algorithm
        for (int i = 0; i < n - 1; i++) {
            // Compare adjacent elements
            for (int j = 0; j < n - 1 - i; j++) {
                // Swap if left element is greater
                if (marks[j] > marks[j + 1]) {
                    // Swap the elements
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                }
            }
        }


        // Step 4: Display sorted marks
        System.out.println("Sorted marks in ascending order:");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }


        scanner.close();
    }
}
