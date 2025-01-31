package com.hashmaphasfunction;

import java.util.*;

class ZeroSumSubarrays {

    // Function to find all subarrays with a sum of zero
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        // List to store subarrays
        List<int[]> result = new ArrayList<>();
        // Stores sum and corresponding indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        // Cumulative sum
        int sum = 0;

        // Initialize map with sum 0 at index -1
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If sum has been seen before, subarrays exist
            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    result.add(new int[]{start + 1, i});
                }
            }

            // Store this sum and the index
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        List<int[]> subarrays = findZeroSumSubarrays(arr);

        // Print all subarrays
        System.out.println("Zero Sum Subarrays:");
        for (int[] subarray : subarrays) {
            System.out.println("Start: " + subarray[0] + ", End: " + subarray[1]);
        }
    }
}
