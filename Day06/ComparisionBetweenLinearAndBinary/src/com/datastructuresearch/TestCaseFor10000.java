package com.datastructuresearch;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class TestCaseFor10000 {
    public static void main(String[] args) {
        // Change dataset size for testing
        int N = 10000;
        // Searching for the last element
        int target = N - 1;

        // Generating random dataset
        Random random = new Random();
        int[] arr = new int[N];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            int num = random.nextInt(N);
            arr[i] = num;
            hashSet.add(num);
            treeSet.add(num);
        }

        // Search in Array
        long startArray = System.currentTimeMillis();
        boolean foundArray = DataStructureSearch.searchArray(arr, target);
        long endArray = System.currentTimeMillis();
        System.out.println("Array Search Found: " + foundArray + " | Time: " + (endArray - startArray) + "ms");

        //  Search in HashSet
        long startHashSet = System.currentTimeMillis();
        boolean foundHashSet = DataStructureSearch.searchHashSet(hashSet, target);
        long endHashSet = System.currentTimeMillis();
        System.out.println("HashSet Search Found: " + foundHashSet + " | Time: " + (endHashSet - startHashSet) + "ms");

        // Search in TreeSet
        long startTreeSet = System.currentTimeMillis();
        boolean foundTreeSet = DataStructureSearch.searchTreeSet(treeSet, target);
        long endTreeSet = System.currentTimeMillis();
        System.out.println("TreeSet Search Found: " + foundTreeSet + " | Time: " + (endTreeSet - startTreeSet) + "ms");
    }
}
