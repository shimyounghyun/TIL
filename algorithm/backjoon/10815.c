#include <stdio.h>
#include <stdlib.h>

int compare(const void *p1, const void *p2)
{
	int a = *((int *)p1);
	int b = *((int *)p2);
	if ( a > b )
		return (1);
	else if ( a < b)
		return (-1);
	else
		return (0);
}

int check(int *arr, int size, int n)
{
	int start;
	int end;
	int mid;

	start = 0;
	end = size;
	mid = (start + end) / 2;
	while (end - start >= 0)
	{
		if (arr[mid] > n )
			end = mid - 1;
		else if (arr[mid] < n)
			start = mid + 1;
		else
			return (1);
		mid = (start + end) / 2;
	}
	return (0);
}

int main()
{
	int n;
	scanf("%d", &n);
	int arr[n];
	for (int i =0; i <n; i++)
		scanf("%d",&arr[i]);
	qsort((void *)arr, n, sizeof(int), compare);	
	int k;
	scanf("%d", &k);
	int t;
	for(int i=0; i<k; i++)
	{
		scanf("%d", &t);
		if (check(arr, n - 1, t))
			printf("1");
		else
			printf("0");
		if (i != k - 1)
			printf(" ");
	}
}
