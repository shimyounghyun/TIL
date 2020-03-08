#include <stdio.h>
#include <stdlib.h>

int arr[501][501];

int	solve(int n, int m, int num)
{
	int result = 0;

	for(int i =0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			if (arr[i][j] > num)
				result += (arr[i][j] - num) * 2;
			else if (arr[i][j] < num)
				result += num - arr[i][j];
		}
	}
	return result;
}

int main()
{
	int n, m;
	long b;
	scanf("%d", &n);
	scanf("%d", &m);
	scanf("%ld", &b);
	if (n <= 0 || m <= 0 || b < 0
			|| n > 500 || m > 500 || b > 64000000)
		return 0;
	int min;
	long max;
	int d;
	min = 0;
	max = b;
	for (int i = 0; i < n; i++)
	{
		for (int j =0; j < m; j++)
		{
			scanf("%d", &d);
			if (min > d)
				min = d;
			max += d;
			arr[i][j] = d;
		}
	}
	max = max / (n * m);
	int time = -1;
	int height;
	int result;
	for (int i = min; i <= max; i++)
	{
		result = solve(n, m, i);
		if (time == -1)
			time = result;
		if (time >= result)
		{
			time = result;
			height = i;
		}
	}
	printf("%d %d", time, height);
	return 0;
}
