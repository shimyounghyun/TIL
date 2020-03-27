#include <stdio.h>

int main()
{
	int result = 0;
	for (int i=0; i<5; i++)
	{
		int n;
		scanf("%d", &n);
		result += n;
	}
	printf("%d", result);
}
