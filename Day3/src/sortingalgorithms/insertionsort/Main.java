package sortingalgorithms.insertionsort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] employeeIDs = { 105, 102, 110, 101, 108, 107 };

        //Print original id's
        System.out.println("Original order of ID's : ");
        for (int i = 0; i < employeeIDs.length; i++) {
            System.out.print(employeeIDs[i]+"  ");
        }
        System.out.println();

        //Sort ID's
        InsertionSort.insertionSort(employeeIDs);

        //Print sorted Order of ID's
        System.out.println("Sorted ID's : "+ Arrays.toString(employeeIDs));
    }
}
