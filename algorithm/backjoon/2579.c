#include <stdio.h>
#define MAX(a, b) ((a) > (b) ? (a) : (b))
int arr[301];
int dp[301];

int main()
{
	int n;
	scanf("%d", &n);
	for(int i=0; i<n; i++)
	{
		scanf("%d", &arr[i]);		
	}

	dp[0] = arr[0];
	dp[1] = MAX(arr[0]+arr[1], arr[1]);
	dp[2] = MAX(arr[1]+arr[2], arr[0]+arr[2]);

	for(int i=3; i<n; i++)
		dp[i] = MAX(dp[i-2]+arr[i], arr[i]+arr[i-1]+dp[i-3]);
	printf("%d", dp[n-1]);
}
