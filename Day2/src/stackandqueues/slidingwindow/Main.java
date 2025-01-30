package stackandqueues.slidingwindow;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        SlidingWindowMaximum swm = new SlidingWindowMaximum();

        System.out.println("Maximum in each sliding window of size " + k + ":");
        swm.findMaxInSlidingWindow(nums, k);  // Output the sliding window maximums
    }
}
