#include <stdio.h>
#define MIN(x,y) ((x) > (y) ? (y) : (x))

int main()
{
	int n;
	scanf("%d",&n);
	int arr[1000001];
	arr[0] = arr[1] = 0;
	for(int i=2; i<=n; i++)
	{
		arr[i] = arr[i-1] + 1;
		if (i % 2 == 0)
			arr[i] = MIN(arr[i/2] + 1, arr[i]);
		if (i % 3 == 0)
			arr[i] = MIN(arr[i/3] + 1,arr[i]);
	}
	printf("%d",arr[n]);
}
