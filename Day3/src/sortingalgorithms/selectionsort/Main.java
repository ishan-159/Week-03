package sortingalgorithms.selectionsort;

public class Main {
    public static void main(String[] args) {

        int[] scores =  {82,74,65,94,85,73};

        // Create an instance of SelectionSort and sort the scores
        SelectionSort sorter = new SelectionSort();
        sorter.sort(scores);

        // Print the sorted scores
        System.out.println("Sorted exam scores:");
        sorter.printArray(scores);
    }
}