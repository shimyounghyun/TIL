#include <stdio.h>

int day[15];

void solve(long long money, int index, int size, long long stock, long long *result)
{
	if (index == size)
	{
		if (*result < money && stock == 0)
			*result = money;
	}
	else
	{
		if (money >= day[index])
			solve(money % day[index], index + 1, size, stock + (money / day[index]), result);
		if (stock > 0)
			solve(money + (stock * day[index]), index + 1, size, 0, result);
		solve(money, index + 1, size, stock, result);
	}
}

int main()
{
	long long n, w;
	scanf("%lld", &n);
	scanf("%lld", &w);
	long long result = w;
	for(int i= 0; i<n; i++)
		scanf("%d", &day[i]);
	solve(w, 0, n, 0, &result);
	printf("%lld", result);
}
