#include <stdio.h>
#include <stdlib.h>
int arr[100001];

int compare(const void *v1, const void *v2)
{
	int i = *(int *)v1;
	int j = *(int *)v2;

	if (i > j)
		return (1);
	else if (i < j)
		return (-1);
	else
		return (0);
}

int gcd(int a, int b)
{
	int r;

	while (b != 0)
	{
		r = a % b;
		a = b;
		b = r;
	}
	return a;
}

int main()
{
	int n;
	scanf("%d", &n);
	
	for (int i=0; i<n; i++)
		scanf("%d", &arr[i]);
	qsort(arr, n, sizeof(int), compare);
	int min = arr[0];
	int max = arr[n-1];
	for (int i=0; i<n-1; i++)
		arr[i] = arr[i+1] - arr[i];
	int prev = arr[0];
	for (int i=1; i<n-2; i++)
		prev = gcd(prev, arr[i]); 
	
	printf("%d", (max-min)/prev-n+1);
}
