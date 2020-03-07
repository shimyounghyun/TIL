#include <stdio.h>

void	solve(int n, int *count)
{
	int i = 1;
	if (n == 0)
		(*count)++;
	else
	{
		while (i <= 3)
		{
			if (n - i >= 0 )
				solve(n - i, count);
			else
				break ;
			i++;
		}
	}
}
int main()
{
	int n;
	scanf("%d", &n);
	int arr[n];
	for (int i=0; i<n; i++)
	{
		scanf("%d", &arr[i]);
	}

	for(int i=0; i<n; i++)
	{
		int count = 0;
		solve(arr[i], &count);
		printf("%d\n", count);
	}
}
