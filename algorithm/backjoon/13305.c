#include <stdio.h>

int n;
int road[100000];
int sumRoad[100000];
int main()
{
	int total_road = 0;
	int total_gas = 0;

	scanf("%d", &n);
	sumRoad[0] = 0;
	for(int i=0; i<n-1; i++)
	{
		scanf("%d", &road[i]);
		total_road += road[i];
		sumRoad[i + 1] = sumRoad[i] + road[i];
	}

	printf("total_road : %d\n", total_road);
	printf("%d %d %d %d", sumRoad[0], sumRoad[1], sumRoad[2], sumRoad[3]);
	
	int pass_road = road[0];
	int sel_gas;
	scanf("%d", &sel_gas);
	int min_cost = 0;
	for(int i=1;i<n;i++)
	{
		min_cost += pass_road * sel_gas;
		int gas;
		scanf("%d", &gas);
		if (gas < sel_gas)
			sel_gas = gas;
		pass_road = road[i-1];
	}
	printf("result %d", min_cost);
	return 0;
}
