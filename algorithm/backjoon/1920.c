#include <stdio.h>
#include <stdlib.h>

int intcmp(const void *pa, const void *pb)
{
    return *(int *)pa > *(int *)pb ? 1 : (*(int *)pa < *(int *)pb ? -1 : 0);
}

void	solve(int *arr,int size, int n)
{
	int start;
	int end;
	int mid;

	start = 0;
	end = size - 1;
	mid = (start + end) / 2;

	while (end - start >= 0)
	{
		if (arr[mid] > n)
			end = mid - 1;
		else if(arr[mid] < n)
			start = mid + 1;
		else
		{
			printf("1\n");
			return ;
		}
		mid = (start + end) / 2;
	}
	printf("0\n");

}

int main()
{
    int n;

    scanf("%d", &n);
    int arr[n];
    int d;
    for(int i = 0; i < n; i++)
    {
        scanf("%d", &d);
        arr[i] = d;
    }
	qsort(arr, n, sizeof(int), intcmp);

	int k;
	scanf("%d", &k);
	int l;
	for (int i =0; i<k; i++)
	{
		scanf("%d", &l);
		solve(arr, n, l);
	}
	
	
}
