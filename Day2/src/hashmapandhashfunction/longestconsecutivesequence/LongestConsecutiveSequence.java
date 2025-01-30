package hashmapandhashfunction.longestconsecutivesequence;

import java.util.*;

class LongestConsecutiveSequence {

    // Function to find the longest consecutive sequence
    public static int findLongestConsecutive(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        // Store all numbers in a HashSet for quick lookup
        Set<Integer> numSet = new HashSet<>();
        for (int num : arr) {
            numSet.add(num);
        }

        int maxLength = 0;

        // Iterate through each number in the array
        for (int num : arr) {
            // Start only if it's the beginning of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // Count consecutive numbers
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                // Update maximum length
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}
