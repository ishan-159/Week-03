package hashmapandhashfunction.longestconsecutivesequence;

public class Main {
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};

        // Call the function from LongestConsecutiveSequence class
        int result = LongestConsecutiveSequence.findLongestConsecutive(arr);

        System.out.println("Length of the longest consecutive sequence: " + result);
    }
}
