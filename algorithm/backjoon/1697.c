#include <stdio.h>
#include <stdlib.h>
int queue[100001] = {0,};
int time[100001] = {0,};

void bfs(int n, int k)
{
	int front = 0;
	int rear = 0;

	queue[rear++] = n;
	time[n] = 0;
	while (front < rear)
	{
		if (queue[front] == k)
		{
			printf("%d", time[queue[front]]);
			break;
		}
		if (queue[front] + 1 <= 100000 && time[queue[front] + 1] == 0)
		{
			queue[rear++] = queue[front] + 1;
			time[queue[front] + 1] = time[queue[front]] + 1;
		}
		if (queue[front] - 1 >= 0 && time[queue[front] - 1] == 0)
		{
			queue[rear++] = queue[front] - 1;
			time[queue[front] - 1] = time[queue[front]] + 1;
		}
		if (queue[front] * 2 <= 100000 && time[queue[front] * 2] == 0)
		{
			queue[rear++] = queue[front] * 2;
			time[queue[front] * 2] = time[queue[front]] + 1;
		}
		front++;
	}
}

int main()
{
	int n,k;
	scanf("%d %d", &n, &k);
	bfs(n, k);
}
