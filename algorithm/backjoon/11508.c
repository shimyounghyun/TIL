#include <stdio.h>
#include <stdlib.h>

int n;
int arr[100000];

int compare(const void *v1, const void *v2)
{
	int i = *(int *)v1;
	int j = *(int *)v2;
	if (i > j)
		return (-1);
	else if(i < j)
		return (1);
	else
		return (0);
}

int main()
{
	scanf("%d", &n);
	for (int i=0; i<n; i++)
		scanf("%d", &arr[i]);
	qsort(arr, n, sizeof(int),compare);
	int result = 0;
	for(int i =0; i<n; i++)
	{
		if((i+1) % 3 != 0 )
			result += arr[i];
	}
	printf("%d", result);
}
