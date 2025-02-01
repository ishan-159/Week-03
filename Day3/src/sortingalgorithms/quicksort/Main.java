package sortingalgorithms.quicksort;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        double[] prices = {205.1, 300.99, 90.10, 25.45, 49.20};

        System.out.println("Unsorted product prices : " + Arrays.toString(prices));

        QuickSort.quickSort(prices, 0, prices.length-1);

        System.out.println("Sorted Prices : "+ Arrays.toString(prices));
    }
}