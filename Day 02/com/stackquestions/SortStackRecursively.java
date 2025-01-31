package com.stackquestions;

import java.util.Stack;

class SortStackRecursively {

    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Pop the top element
            int temp = stack.pop();
            // Recursively sort the remaining stack
            sortStack(stack);
            // Insert the popped element at the correct position
            insertSorted(stack, temp);
        }
    }

    // Helper function to insert an element in a sorted stack
    private static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            // Insert when stack is empty or element is greater
            stack.push(element);
            return;
        }
        // Remove top element
        int temp = stack.pop();
        // Recursively find correct position
        insertSorted(stack, element);
        // Push the element back
        stack.push(temp);
    }

    // Driver code to test sorting
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}

