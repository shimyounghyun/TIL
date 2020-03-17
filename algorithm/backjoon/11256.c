#include <stdio.h>
#include <stdlib.h>

int compare(const void *v1, const void *v2)
{
	int vv1 = *(int *)v1;
	int vv2 = *(int *)v2;
	if ( vv1 > vv2)
		return (-11);
	else if (vv1 < vv2)
		return (1);
	else
		return (0);
}

int main()
{
	int t;
	scanf("%d", &t);

	for (int i=0; i<t; i++)
	{
		int candy;
		int count;
		scanf("%d %d", &candy, &count);
		int index = 0;
		int arr[1001] = {0};
		int result = 0;
		for (int j=0; j<count; j++)
		{
			int w,h;
			scanf("%d %d", &w, &h);
			arr[j] = w * h;	
		}
		qsort(arr, count, 4, compare);
		while (candy > 0)
		{
			candy = candy - arr[index++];
			result++;
		}
		printf("%d\n", result);
	}
}
