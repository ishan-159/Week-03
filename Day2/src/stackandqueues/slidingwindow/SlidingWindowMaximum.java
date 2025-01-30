package stackandqueues.slidingwindow;

import java.util.Deque;
import java.util.LinkedList;

class SlidingWindowMaximum {

    // Method to find the maximum in each sliding window of size k
    public void findMaxInSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return;
        }

        Deque<Integer> deque = new LinkedList<>();

        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            // Remove indices that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove indices of all elements smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // Add the current element's index to the deque
            deque.offerLast(i);

            // The first window is ready to be added to the result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        // Print the result
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}