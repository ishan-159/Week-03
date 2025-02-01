package sortingalgorithms.mergesort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] bookPrices = {509.99, 249.50, 599.75, 150.25, 699.99, 99.39, 459.00};

        //Print original Prices
        System.out.println("Original Prices : "+Arrays.toString(bookPrices));

        //Sort the prices
        MergeSort.mergeSort(bookPrices,0, bookPrices.length-1);

        //Printing the sorted Prices
        System.out.println("Sorted Prices : "+Arrays.toString(bookPrices));


    }
}

