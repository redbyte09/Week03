package com.hashmaphasfunction;

import java.util.*;

class LongestConsecutiveSequence {

    // Function to find the longest consecutive sequence
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num); // Store unique elements
        }

        int longestStreak = 0;

        // Traverse each number and find the longest sequence
        for (int num : nums) {
            // Check if it is a starting point (no num-1 in set)
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count the consecutive sequence
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Sequence Length: " + longestConsecutive(arr));
    }
}

