#include <stdio.h>

int match(int i, int j)
{
	if (i > j)
		if ( i % 2 == 0 && i - 1 == j)
			return 1;
		else
			return 0;
	else
		if ( j % 2 == 0 && j -1 == i)
			return 1;
		else
			return 0;
}

void	solve(int round, int total, int i, int j)
{
	if (match(i, j))
		printf("%d", round);
	else
		solve(round + 1, (total>>1)+(total%2), (i>>1)+(i%2), (j>>1)+(j%2));
}

int main()
{
	int n, i, j;
	scanf("%d", &n);
	scanf("%d", &i);
	scanf("%d", &j);
	solve(1, n, i, j);
}
