package com.hashmaphasfunction;

import java.util.HashMap;

public class TwoSum {

    // Function to find two indices that add up to the target sum
    public static int[] twoSum(int[] nums, int target) {
        // HashMap to store element values and their indices
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // Return the indices
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        int[] result = twoSum(nums, target);

        if (result.length == 0) {
            System.out.println("No solution found.");
        } else {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        }
    }
}
