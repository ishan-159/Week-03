package hashmapandhashfunction.subarrayswithzerosum;

import java.util.*;

class ZeroSumSubarrays {

    // Method to find and print all subarrays with zero sum
    public static void findZeroSumSubarrays(int[] arr) {
        // Map to store cumulative sum and corresponding indices
        Map<Integer, List<Integer>> sumMap = new HashMap<>();

        // Initialize the cumulative sum
        int sum = 0;

        // List to store pairs of subarrays
        List<int[]> result = new ArrayList<>();

        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];  // Compute cumulative sum

            // If sum is found in map, it means a zero-sum subarray exists
            if (sumMap.containsKey(sum)) {
                for (int startIdx : sumMap.get(sum)) {
                    result.add(new int[]{startIdx + 1, i});
                }
            }

            // Add current index to the list of indices for this sum
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }

        // Print the subarrays
        if (result.isEmpty()) {
            System.out.println("No subarray with zero sum found.");
        } else {
            System.out.println("Subarrays with zero sum:");
            for (int[] range : result) {
                System.out.println("Start: " + range[0] + ", End: " + range[1]);
            }
        }
    }
}