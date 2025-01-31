package com.stackquestions;

import java.util.Deque;
import java.util.LinkedList;

class SlidingWindowMaximum {

    // Function to find the maximum in each sliding window of size k
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];

        int n = nums.length;
        // Output array
        int[] result = new int[n - k + 1];
        // Deque to store indices
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove elements that are out of this window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements smaller than the current element from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current element index
            deque.addLast(i);

            // Store max value for windows of size k (start recording after index k-1)
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    // Driver Code to test the function
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = maxSlidingWindow(nums, k);

        // Print the output
        System.out.print("Sliding Window Maximums: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

