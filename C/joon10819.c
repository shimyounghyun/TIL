#include <stdlib.h>
#include <stdio.h>
#define ABS(x) ((x) < 0 ? -(x) : (x))
int arr[8];
void swap(int *a, int *b)
{
	int temp;
	temp = *a;
	*a = *b;
	*b = temp;
}
int cal(int size)
{
	int result = 0;
	for(int i=0; i<size -1; i++)
	{
		result += ABS(arr[i] - arr[i+1]);
	}	
	return result;
}
void solve(int index, int size, int *result)
{
	if (index == size)
	{
		int cal_r = cal(size);
		if (*result < cal_r)
			*result = cal_r;
	}
	else
	{
		int target = index;
		while(target < size)
		{
			swap(&arr[index], &arr[target]);
			solve(index + 1, size, result);
			swap(&arr[target], &arr[index]);
			target++;	
		}
	}
}
int main()
{
	int n;
	scanf("%d", &n);
	for (int i=0; i<n; i++)
		scanf("%d", &arr[i]);
	int result = 0;
	solve(0,n,&result);
	printf("%d",result);
}
