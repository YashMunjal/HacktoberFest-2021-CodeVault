public class Main
{
   static void selectionSort(int arr[], int n)
   {
       int min_index;
      
       for (int i = 0; i < n-1; i++)
       {
           min_index = i;
           for (int j = i+1; j < n; j++)
           {
               if (arr[j] < arr[min_index])
                   min_index = j;
           }
          
           int temp = arr[min_index];
           arr[min_index] = arr[i];
           arr[i] = temp;
       }
   }
  
   static void printArray(int arr[], int n)
   {
       for (int i = 0; i < n; i++)
           System.out.print(arr[i] + " ");
       System.out.println();
   }
  
   public static void main(String args[])
   {
       int arr[] = {6, 3, 8, 9, 5};
       int n = arr.length;
      
       System.out.print("Given Array: ");
       printArray(arr, n);
      
       selectionSort(arr, n);
      
       System.out.print("Sorted Array: ");
       printArray(arr, n);
   }
}
