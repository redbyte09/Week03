package com.datastructuresearch;
import java.util.*;
public class DataStructureSearch {




        // 🔹 Search in Array (O(N) - Linear Search)
        public static boolean searchArray(int[] arr, int target) {
            for (int num : arr) {
                if (num == target) {
                    return true;
                }
            }
            return false;
        }

        // 🔹 Search in HashSet (O(1) on average)
        public static boolean searchHashSet(HashSet<Integer> set, int target) {
            return set.contains(target);
        }

        // 🔹 Search in TreeSet (O(log N))
        public static boolean searchTreeSet(TreeSet<Integer> treeSet, int target) {
            return treeSet.contains(target);
        }
    }

