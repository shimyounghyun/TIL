#include <stdlib.h>
#include <stdio.h>

void	arr_print(int *arr)
{
	for(int i=0; i<6; i++)
		printf("%d ", arr[i]);
	printf("\n");
}

void solve(int *arr, int *result, int index, int size, int target)
{
	if (index == 6)
		arr_print(result);	
	else if (target == size)
		return ;
	else
	{
		while (target <= size - 6 + index)
		{
			result[index] = arr[target];
			solve(arr, result, index + 1, size, target + 1);
			target++;
		}
	}
}

int main()
{
	int n;
	int flag = 0;
	while (1)
	{
		scanf("%d" ,&n);
		if (n == 0)
			break ;
		if (flag != 0)
			printf("\n");
		int arr[n];
		int result[6];
		for (int i=0; i<n; i++)
			scanf("%d", &arr[i]);
		solve(arr, result, 0, n, 0);
		flag++;
	}
}
