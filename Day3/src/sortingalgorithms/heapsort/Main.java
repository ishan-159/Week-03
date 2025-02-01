package sortingalgorithms.heapsort;

public class Main {
    public static void main(String[] args) {

        int[] salaries = {31000,12000,63000,24000,55000,32000};
        System.out.println("Enter expected salary demands:");

        HeapSort heapSort = new HeapSort();
        heapSort.sort(salaries);

        System.out.println("Sorted salary :");
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }

    }
}
