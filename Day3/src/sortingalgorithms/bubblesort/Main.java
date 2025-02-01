package sortingalgorithms.bubblesort;

public class Main {
    public static void main(String[] args) {
        int [] marks = {82,74,65,94,85,73};

        //Print original marks
        System.out.println("Origin marks : ");
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i]+"  ");
        }
        System.out.println();

        //Sort marks
        BubbleSort.bubbleSort(marks);

        //Printing sorted marks
        System.out.println("sorted marks : ");
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i]+"  ");
        }
    }
}
