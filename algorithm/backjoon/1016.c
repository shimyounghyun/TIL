#include <stdio.h>

long long n;
long long m;
long long d[1000001];

int main()
{
	scanf("%lld %lld", &n, &m);
	for (long long i=2; i*i<=m; i++)
	{
		long long s = n/(i*i);
		if (n%(i*i)!=0)
			s++;
		while (s*i*i <= m)
		{
			d[s*i*i-n] = 1;
			s++;
		}
	}
	int result = 0;
	for (int i=0; i<=m-n; i++)
	{
		if (d[i]==0)
			result++;
	}
	printf("%d", result);
	return (0);
}
