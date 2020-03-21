#include <stdio.h>
#include <stdlib.h>

long long arr[100000];
long long acc[100000];
int n;

int compare(const void *v1, const void *v2)
{
	int i = *(int *)v1;
	int j = *(int *)v2;

	if (i > j)
		return (1);
	else if( i < j)
		return (-1);
	else
		return (0);
}
int main()
{
	scanf("%d", &n);
	for(int i=0; i<n; i++)
		scanf("%lld", &arr[i]);
	for(int i=0; i<n; i++)
		scanf("%lld", &acc[i]);
	qsort(acc, n, sizeof(long long), compare);
	long long result = 0;

	for(int i=0; i<n; i++)
		result += arr[i] + acc[i] * i;
	printf("%lld", result);
}
