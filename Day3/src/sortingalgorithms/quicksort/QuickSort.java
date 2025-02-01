package sortingalgorithms.quicksort;

import java.util.*;

public class QuickSort {
    public static void quickSort(double[] prices, int low, int high){

        if(low<high){

            int pivotIndex = pivot(prices, low, high);

            quickSort(prices, low, pivotIndex-1);
            quickSort(prices, pivotIndex+1,  high);
        }
    }
    public static int pivot(double[] prices, int low, int high){

        int i=low+1;
        int j=high;
        double pivot = prices[low];

        while(i<=j){

            while(i<=j && prices[i] <= pivot){
                i++;
            }
            while (j>=i && prices[j] > pivot) {
                j--;
            }

            if(i<j) swap(prices, i, j);
        }
        swap(prices, low, j);
        return j;
    }
    public static void swap(double[] prices, int i, int j){
        double temp = prices[i];
        prices[i] = prices[j];
        prices[j] = temp;
    }
}

