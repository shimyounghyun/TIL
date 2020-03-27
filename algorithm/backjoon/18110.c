#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int arr[300001];

int compare(const void *v1, const void *v2)
{
	int t1 = *(int *)v1;
	int t2 = *(int *)v2;

	if( t1 < t2)
		return (1);
	else if(t1 > t2)
		return (-1);
	else
		return (0);
}

int main()
{
	int n;
	scanf("%d", &n);
	for(int i=0; i<n; i++)
		scanf("%d", &arr[i]);
	int front = floor((double)n*15/100+0.5);
	int rear = n - front;
	int count = rear - front;
	qsort(arr, n, 4, compare);
	int lv = 0;
	while (front < rear)
		lv += arr[front++];
	if (lv != 0)
		lv = floor((double)lv/count+0.5);
	printf("%d", lv);
}
