#include <stdio.h>
#define Max(a, b) ((a) > (b) ? (a) : (b))
int dp[501][501] = {0};

int main()
{
	int n;
	scanf("%d", &n);
	int m = 0;
	for(int i=0; i<n; i++)
	{
		for (int j = 0; j < i+1; j++)
		{
			int d;
			int cal = i > 0 ? i - 1 : i;
			scanf("%d", &d);
			if (j == 0)
				dp[i][j] = dp[cal][0] + d;
			else if (j == i)
				dp[i][j] = dp[cal][j-1] + d;
			else
				dp[i][j] = Max(dp[cal][j]+d, dp[cal][j-1]+d);
			if ( m < dp[i][j])
				m = dp[i][j];
		}
	}
	printf("%d", m);
}
