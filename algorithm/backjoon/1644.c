#include <stdio.h>
#include <math.h>
int d[4000001] = {0};
int p[300000];

int main()
{
	int k = 0;
	for (int i=2; i<= 4000000; i++){
		if (d[i]) {
			continue;
		}
		for (int j= i+i; j<= 4000000; j+=i){
			d[j] = 1;
		}
	}
	for (int i=2; i<=4000000;i++){
		if(!d[i]){
			p[k++] = i;
		}
	}
	int s=0;
	int front = 0;
	int rear = 0;
	int result = 0;
	int n;
	scanf("%d", &n);
	
	while (rear <= k)
	{
		if (s < n)
		{
			s += p[rear++];
			continue;
		}

		if (s == n)
			result++;
		s -= p[front++];
	}
	printf("%d", result);
	return (0);
}
