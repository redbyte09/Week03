package com.hashmaphasfunction;

import java.util.*;

class PairWithGivenSum {

    // Function to check if a pair exists with the given sum
    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            // Find the required pair element
            int complement = target - num;

            // If the complement exists in the set, we found a pair
            if (set.contains(complement)) {
                System.out.println("Pair found: (" + num + ", " + complement + ")");
                return true;
            }
            set.add(num);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 17;

        if (!hasPairWithSum(arr, target)) {
            System.out.println("No pair found.");
        }
    }
}

