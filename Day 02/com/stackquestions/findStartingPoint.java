package com.stackquestions;

class CircularTour {

    // Function to find the starting petrol pump index
    public static int findStartingPoint(int[] petrol, int[] distance) {
        // Overall surplus to check feasibility
        int total_surplus = 0;
        // Surplus petrol in the journey
        int current_surplus = 0;
        // Starting point for the circular tour
        int start_index = 0;

        for (int i = 0; i < petrol.length; i++) {
            int fuel_gain = petrol[i] - distance[i];
            total_surplus += fuel_gain;
            current_surplus += fuel_gain;

            // If current surplus becomes negative, reset starting point
            if (current_surplus < 0) {
                start_index = i + 1;
                current_surplus = 0;
            }
        }

        // If total surplus is negative, a complete tour is impossible
        return (total_surplus >= 0) ? start_index : -1;
    }

    // Driver code to test the function
    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int start = findStartingPoint(petrol, distance);

        // Print the starting petrol pump index
        System.out.println(start == -1 ? "Tour not possible" : "Start at petrol pump: " + start);
    }
}

