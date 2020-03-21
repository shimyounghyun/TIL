#include <stdio.h>

int n;
int road[100000];
int main()
{
	scanf("%d", &n);
	for(int i=0; i<n-1; i++)
		scanf("%d", &road[i]);
	road[n - 1] = 0;
	long long gas;
	long long cost = 0;
	scanf("%lld",&gas);
	cost = road[0] * gas;
	// 2 3 1
	// 5 2 4 1
	for(int i=1; i<n; i++)
	{
		long long sel_gas;
		scanf("%lld",&sel_gas);
		if (sel_gas < gas)
			gas = sel_gas;
		cost += road[i] * gas;
	}
	printf("%lld",cost);
}
