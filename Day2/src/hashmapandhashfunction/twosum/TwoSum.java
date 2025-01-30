package hashmapandhashfunction.twosum;

import java.util.HashMap;

class TwoSum {
    public static int[] findTwoSum(int[] nums, int target) {
        // Stores number -> index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // Required pair value
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                // Return indices
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i); // Store the number and its index
        }

        return new int[]{-1, -1};
    }
}

