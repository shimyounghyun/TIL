#include <stdio.h>

int n;
int m;
int arr[501][501];

int main()
{
	scanf("%d %d", &n, &m);

	for (int i=0; i<m; i++)
	{
		int f,s;
		scanf("%d %d", &f, &s);
		arr[f][s] = 1;
	}
	
	for (int i=1; i<=n; i++)
	{
		for (int j=1; j<=n; j++)
			printf("%d ", arr[i][j]);
		printf("\n");
	}
	printf("\n");
	for (int k = 1; k <= n; k++)
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
			{
				if (arr[i][k]  == 1&& arr[k][j] == 1)
					arr[i][j] = 1;
			}

	for (int i=1; i<=n; i++)
	{
		for (int j=1; j<=n; j++)
			printf("%d ", arr[i][j]);
		printf("\n");
	}
	printf("\n");
	int ans = 0;
	for (int i = 1; i <= n; i++)
	{
		int cnt = 0;
		for (int j = 1; j <= n; j++)
		{
			if (i == j)continue;
			if (arr[i][j] == 0 && arr[j][i] == 0)
				cnt++;
		}
		if (cnt == 0)ans++;
	}
	printf("%d", ans);
}
