#include <stdio.h>
#include <stdlib.h>
# define MAX 26
int map[MAX][MAX];
int result[MAX];
int dx[4] = {0,0,1,-1};
int dy[4] = {1,-1,0,0};

void dfs(int i, int j, int *count, int leng)
{
	map[i][j] = 0;
	*count = *count + 1;
    for(int k=0; k<4; k++)
    {
        if (dx[k] + j >= leng || dy[k] + i >= leng || dx[k] + j < 0 || dy[k] + i < 0) continue;
        if (map[i+dy[k]][j+dx[k]] == 1)
            dfs(i+dy[k], j+dx[k], count, leng);
    }
}

int compare(const void *a, const void *b)
{
	int *t1;
	int *t2;

	t1 = (int *)a;
	t2 = (int *)b;
	if (*t1 > *t2)
		return (1);
	else if(*t1 < *t2)
		return (-1);
	else
		return (0);
}

int main()
{
	int n;
	scanf("%d", &n);

	for(int i=0; i<n; i++)
		for (int j=0; j<n; j++)
            scanf("%1d", &map[i][j]);

	for (int i=0; i<MAX; i++)
		result[i] = 0;
	
	int r = 0;
	for(int i=0; i<n; i++)
		for(int j=0; j<n; j++)
			if(map[i][j] == 1)
			{
				int count = 0;
				dfs(i, j, &count, n);
				result[r++] = count;
			}

	printf("%d\n", r);    
    qsort(result, r, 4, compare);
	for(int i=0; i<r; i++)
		printf("%d\n",result[i]);
}

