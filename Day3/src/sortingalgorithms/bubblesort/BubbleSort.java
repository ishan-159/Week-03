package sortingalgorithms.bubblesort;

public class BubbleSort {
    public static void bubbleSort(int [] marks) {

        int n = marks.length;

        for(int turn=0;turn<n-1;turn++){
            for (int j = 0; j < n-1-turn; j++) {

                if(marks[j]>marks[j+1]){
                    int temp = marks[j];
                    marks[j] = marks[j+1];
                    marks[j+1]=temp;
                }

            }
        }

    }
}
