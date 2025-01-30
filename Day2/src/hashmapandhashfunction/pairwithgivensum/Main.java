package hashmapandhashfunction.pairwithgivensum;

public class Main {
    //Main Method
    public static void main(String[] args) {
        int[] arr = {8, 4, 6, 3, 7, 1, 9};
        int target = 10;

        // Call the function from PairWithGivenSum class
        boolean result = PairWithGivenSum.hasPairWithSum(arr, target);

        if (!result) {
            System.out.println("No pair with the given sum found.");
        }
    }
}
