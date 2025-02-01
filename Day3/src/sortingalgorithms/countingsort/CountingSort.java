package sortingalgorithms.countingsort;

public class CountingSort {
    public void sort(int[] ages, int minAge, int maxAge) {
        int range = maxAge - minAge + 1;
        int[] count = new int[range];
        int[] output = new int[ages.length];

        // Step 1: Count the occurrences of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Step 2: Compute frequency
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Place elements in sorted order
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Copy sorted output
        System.arraycopy(output, 0, ages, 0, ages.length);
    }
}
