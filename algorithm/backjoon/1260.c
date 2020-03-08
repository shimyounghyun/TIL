#include <stdio.h>

#define MAX_VERTEX 1001
int map[MAX_VERTEX][MAX_VERTEX];
int visit[MAX_VERTEX];
int queue[MAX_VERTEX];

void dfs(int v, int max)
{
	visit[v] = 1;
	printf("%d", v);
	for(int i=0; i<=max; i++)
		if (map[v][i] == 1 && visit[i] == 0)
		{
			printf(" ");
			dfs(i, max);
		}
}

void bfs(int v, int max)
{
	visit[v] = 1;
	printf("%d", v);
	int front = 0;
	int rear = 0;
	queue[rear++] = v;
	
	while (front < rear)
	{
		for (int i =0; i<=max; i++)
		{
			if (map[queue[front]][i] == 1 && visit[i] == 0) 
			{
				visit[i] = 1;
				queue[rear++] = i;
				printf(" %d", i);
			}
		}
		front++;
	}
}

int main()
{
	int n, m, v;
	scanf("%d", &n);
	scanf("%d", &m);
	scanf("%d", &v);
	
	for (int i=0; i<n; i++)
	{
		for (int j=0; j<n; j++)
			map[i][j] = 0;
		visit[i] = 0;
	}

	for (int i=0; i<m; i++)
	{
		int x;
		int y;
		scanf("%d %d", &y, &x);
		map[y][x] = map[x][y] = 1;
	}

	dfs(v, n);
	for (int i=0; i<=n; i++)
		visit[i] = 0;
	printf("\n");
	bfs(v, n);
}
