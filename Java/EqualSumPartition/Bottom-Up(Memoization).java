/* Equal Sum Partition (Bottom-Up) */

import java.util.*;

class GFG{
    static int isSubsetSum(int arr[],int n,int sum)
    {
        if(n==0)
          return 0;
        
        if(sum==0)
          return 1;
          
        int dp[][] = new int[n+1][sum+1];
        
        if(dp[n][sum]!=0)
        {
            return dp[n][sum];
        }
        
        if(arr[n-1]<=sum)
          {
            dp[n][sum] = Math.max(isSubsetSum(arr,n-1,sum-arr[n-1]),isSubsetSum(arr,n-1,sum));
            
            //if we make it boolean type then we should use || else max.
          }
        else
          {
            dp[n][sum] = isSubsetSum(arr,n-1,sum);
          }
        return dp[n][sum];
    }
    static int equalPartition(int N, int arr[])
    {
        int sum=0;
        for(int i=0;i<N;i++)
        {
            sum=sum+arr[i];
        }
        if(sum%2!=0)
          return 0;
          
        return isSubsetSum(arr,N,sum/2);
    }
	public static void main (String[] args) {
	   Scanner obj = new Scanner(System.in);
	   int n=obj.nextInt();
	   int arr[] = new int[n];
	   for(int i=0;i<n;i++)
	   {
	       arr[i]=obj.nextInt();
	   }
	   
	   System.out.print(equalPartition(n,arr));
	}
}
