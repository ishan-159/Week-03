package sortingalgorithms.insertionsort;

public class InsertionSort {
    public static void insertionSort(int [] arr ) {

        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i-1;
            while(prev>=0 && arr[prev]>curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;

        }

    }
}

