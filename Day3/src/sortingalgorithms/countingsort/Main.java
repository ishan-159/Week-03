package sortingalgorithms.countingsort;

public class Main {
    public static void main(String[] args) {
        int[] ages = {14, 12, 16, 11, 18, 12, 10, 15, 17, 13};

        CountingSort countingSort = new CountingSort();
        countingSort.sort(ages, 10, 18);

        System.out.println("Sorted student ages (Ascending Order):");
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }
}

