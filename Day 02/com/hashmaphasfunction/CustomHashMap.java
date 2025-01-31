package com.hashmaphasfunction;

import java.util.LinkedList;

class CustomHashMap {

    private static final int SIZE = 10; // Initial size of the hash map
    private LinkedList<Entry>[] map;

    // Define the Entry class to store key-value pairs
    private static class Entry {
        String key;
        Integer value;

        Entry(String key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor: Initialize the hash map with an array of linked lists
    public CustomHashMap() {
        map = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            map[i] = new LinkedList<>();
        }
    }

    // Hash function: Computes the index based on the key
    private int hash(String key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    // Insert a key-value pair into the hash map
    public void insert(String key, Integer value) {
        int index = hash(key);
        LinkedList<Entry> bucket = map[index];

        // Check if the key already exists in the bucket
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry(key, value));
    }

    // Retrieve the value associated with a given key
    public Integer get(String key) {
        int index = hash(key);
        LinkedList<Entry> bucket = map[index];

        // Traverse the bucket to find the key and return the value
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    // Delete the key-value pair from the hash map
    public boolean delete(String key) {
        int index = hash(key);
        LinkedList<Entry> bucket = map[index];

        // Traverse the bucket to find and remove the entry
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                return true;
            }
        }
        return false;
    }

    // Display the contents of the hash map (for debugging)
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            LinkedList<Entry> bucket = map[i];
            if (!bucket.isEmpty()) {
                System.out.print("Index " + i + ": ");
                for (Entry entry : bucket) {
                    System.out.print("(" + entry.key + ": " + entry.value + ") -> ");
                }
                System.out.println("null");
            }
        }
    }

    // Main method for testing the CustomHashMap
    public static void main(String[] args) {
        CustomHashMap customHashMap = new CustomHashMap();

        // Inserting values
        customHashMap.insert("apple", 100);
        customHashMap.insert("banana", 200);
        customHashMap.insert("orange", 300);

        // Retrieving values
        System.out.println("Apple: " + customHashMap.get("apple"));
        System.out.println("Banana: " + customHashMap.get("banana"));
        System.out.println("Orange: " + customHashMap.get("orange"));

        // Deleting a key
        customHashMap.delete("banana");
        System.out.println("Banana after delete: " + customHashMap.get("banana"));

        // Display the map contents
        customHashMap.display();
    }
}
