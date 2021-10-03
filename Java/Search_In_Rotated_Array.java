
/* 
  Author - Shaan Alam (@shaan-alam)
  Description - Solution to a leetcode problemt
  Link - https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
*/

public class Search_In_Rotated_Array {
  public int search(int[] nums, int target) {
    int pivot = findPivot(nums);
    int start = 0;

    System.out.println("Peak" + pivot);
    int index = binarySearch(nums, start, pivot, target);
    if (index == -1) {
      index = binarySearch(nums, pivot + 1, nums.length - 1, target);
    }
    return index != -1 ? index : -1;
  }

  public int binarySearch(int[] arr, int start, int end, int target) {

    while (start <= end) {
      int mid = (start + end) / 2;
      if (target > arr[mid]) {
        start = mid + 1;
      } else if (target < arr[mid]) {
        end = mid - 1;
      } else {
        return mid;
      }

    }

    return -1;
  }

  public static int findPivot(int[] arr) {
    int start = 0;
    int end = arr.length - 1;

    while (start <= end) {
      int mid = (start + end) / 2;

      if (mid < end && arr[mid] > arr[mid + 1]) {
        return mid;
      }
      if (mid > start && arr[mid] < arr[mid - 1]) {
        return mid - 1;
      }

      if (arr[mid] <= arr[start]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return -1;
  }
}