/* Equal Sum Partition (Top-Down) */

import java.util.*;

class GFG{
    static int isSubsetSum(int arr[],int n,int sum)
    {
        int dp[][] = new int[n+1][sum+1];
        
        for(int i=0;i<=n;i++)
        {
            dp[i][0]=1;
        }
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(arr[i-1]<=j)
                {
                    dp[i][j] = Math.max(dp[i-1][j-arr[i-1]],dp[i-1][j]);
                    
                    //if we make it boolean type then we should use || else max.
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
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
