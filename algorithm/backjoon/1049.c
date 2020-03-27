#include <stdio.h>
#include <stdlib.h>

int require;
int set[51];
int single[51];

int compare(const void *v1, const void *v2)
{
	int i = *(int *)v1;
	int j = *(int *)v2;
	if (i > j)
		return (1);
	else if(i < j)
		return (-1);
	else
		return (0);
}

void min(int a,int b,int c)
{
	printf("%d", a > b ? (b > c ? c : b) : (a > c ? c : a));
}

int main()
{
	int brand;
	scanf("%d %d", &require, &brand);

	for(int i=0; i<brand; i++)
		scanf("%d %d", &set[i], &single[i]);
	qsort(set, brand, 4, compare);	
	qsort(single, brand, 4, compare);
	
	int onlySingle = require * single[0];
	int onlySet = (require%6 !=0 ? require/6+1 : require/6) * set[0];
	int suffle = require%6 !=0? require/6*set[0]+(require%6)*single[0] : 2100000000;
	min(onlySingle, onlySet, suffle);

}
