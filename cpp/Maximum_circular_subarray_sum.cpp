#include <iostream>
#include<climits>
using namespace std;
int Kadane(int a[],int n)
{
    int max_local_sum=a[0];
    int overall_sum=a[0];
    for(int i=1;i<n;i++)
    {
        if(max_local_sum>=0)
        {
            max_local_sum=max_local_sum+a[i];
        }
        else
        {
            max_local_sum=a[i];
        }
        if(max_local_sum>overall_sum)
        {
            overall_sum=max_local_sum;
        }

    }
    return overall_sum;
}
int main() 
{
	int n;
	cin >>n;
	int a[n];
	for(int i=0;i<n;i++)
	{
	    cin >> a[i];
	}
	int nonwrapSum=Kadane(a,n);
	int wrapSum,totalsum=0;
	for(int i=0;i<n;i++)
	{
	    totalsum=totalsum+a[i];
	    a[i]=-a[i];
	}
	wrapSum=totalsum+Kadane(a,n);
	cout << max(wrapSum,nonwrapSum);
	return 0;
}