package hashmapandhashfunction.pairwithgivensum;

import java.util.*;

class PairWithGivenSum {

    //Method to check if a pair with the given sum exists
    public static boolean hasPairWithSum(int[] arr, int target) {
        // HashSet to store visited numbers
        Set<Integer> seenNumbers = new HashSet<>();

        for (int num : arr) {
            int complement = target - num; // Find the required complement

            // If complement exists in the set, return true
            if (seenNumbers.contains(complement)) {
                System.out.println("Pair found: (" + num + ", " + complement + ")");
                return true;
            }

            // Add current number to the set
            seenNumbers.add(num);
        }

        return false; // No pair found
    }
}
