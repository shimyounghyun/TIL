#include <stdio.h>
#define MAX 11

int map[MAX][MAX] = {0};
int result[MAX][MAX] = {0};

int dx[4] ={ 0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
typedef struct xy{
    int x;
    int y;
}               xy;
void bfs(int n, int m)
{
    xy queue[MAX * MAX];
    int front = 0;
    int rear = 0;

    int i = 0;
    int j = 0;
    queue[rear].y = i;
    queue[rear].x = j;
    rear++;
    result[i][j] = 1;
    map[i][j] = 0;
    while(front < rear){
        i = queue[front].y;
        j = queue[front].x;
        for(int k=0; k<4; k++)
        {
            if (i + dy[k] < 0 || j + dx[k] < 0 || i + dy[k] >= n || j + dx[k] >= m)
                continue;
            if (map[i +dy[k]][j + dx[k]] == 1)
            {
                result[i +dy[k]][j + dx[k]] = result[i][j] + 1;
                map[i +dy[k]][j + dx[k]] = 0;
                queue[rear].y = i+dy[k];
                queue[rear].x = j+dx[k];
                rear++;
            }
        }
        front++;
    }
    printf("%d", result[n-1][m-1]);
}

int	main()
{
    int n,m;
    scanf("%d %d", &n, &m);

    for(int i=0; i<n; i++)
        for(int j=0; j<m; j++)
            scanf("%1d",&map[i][j]);
    
    bfs(n, m);
}
