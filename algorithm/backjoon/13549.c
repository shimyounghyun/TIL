#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int queue[100001] = {0,};
int time[100001];

void bfs(int n, int k)
{
	int front = 0;
	int rear = 0;
	
    for (int i=0; i<100001; i++)
        time[i] = -1;
    queue[rear++] = n;
    time[n] = 0;
	while (front < rear)
	{
        int num = queue[front];
        if (num == k)
        {
            break;
        }
        if (num * 2 <= 100000 && time[num * 2] == -1)
		{
			queue[rear++] = num * 2;
			time[num * 2] = time[num];
		}
		if (num + 1 <= 100000 && time[num + 1] == -1)
		{
			queue[rear++] = num + 1;
			time[num + 1] = time[num] + 1;
		}
		if (num - 1 >= 0 && time[num - 1] == -1)
		{
			queue[rear++] = num - 1;
			time[num - 1] = time[num] + 1;
		}
		front++;
	}    
    printf("%d", time[k]);
}

int main()
{
	int n,k;
	scanf("%d %d", &n, &k);
	bfs(n, k);
}
