package SelectionSort;

import java.util.Arrays;

public class SelectionSortCode {
    public static void main(String[] args) {
        int[] arr = {0,-65,65,-99,-7,55,31,1,-8};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    // selection sort
    static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            // find the max item in remaining array and swap with correct index
            int last = arr.length - 1 - i;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr, maxIndex, last);
        }
    }
    // swap elements
    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    // find maximum element index
    static int getMaxIndex(int[] arr, int start, int end){
        int max = start;
        for (int i = start; i <= end; i++) {
            if(arr[max] < arr[i]){
                max = i;
            }
        }
        return max;
    }
}

/*
Time Complexity
(1). Best Case :- O(n^2)
(2). Worst Case :- O(n^2)

-> Selection sort is not stable
-> It performs well on small lists
*/