#include <stdio.h>
#define Max(a, b) ((a) > (b) ? (a) : (b))
int dp[501] = {0};

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
			scanf("%d", &d);
			if (j == 0)
				dp[j] = dp[0] + d;
			else if (j == i)
				dp[j] = dp[j-1] + d;
			else
				dp[j] = Max(dp[j], dp[j-1]) + d;
			if ( m < dp[j])
				m = dp[j];
		}
	}
	printf("dp0 : %d\n",dp[0]);
	printf("dp1 : %d\n",dp[1]);

	printf("%d", m);

}
