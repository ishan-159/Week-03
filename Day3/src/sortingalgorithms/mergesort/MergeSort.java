package sortingalgorithms.mergesort;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(double [] arr , int si , int ei) {

        if(si >= ei){
            return;
        }
        int mid = si + (ei - si)/2 ;


        mergeSort(arr,si,mid); //left
        mergeSort(arr,mid+1,ei);  //right
        merge(arr,si,mid,ei);  //merge

    }

    public static void merge(double [] arr , int si , int mid , int ei) {
        int i = si;
        int j = mid+1;
        int k =0;
        double [] temp = new double[ei-si +1];

        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k] = arr[i];
                i++; k++;
            }else {
                temp[k] = arr[j];
                j++; k++;
            }


        }

        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=ei){
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp , 0 , arr , si ,  temp.length);
    }
}

