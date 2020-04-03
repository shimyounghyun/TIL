#include <stdio.h>
int map[100002]={0};
int n,m;
int main()
{
	scanf("%d %d", &n, &m);
	int stack[100002];
	int front = 0;
	int rear = 0;
	int ans = 0;
	map[n] = 0;
	stack[rear++] = n;
	while (front != rear)
	{
		int k = stack[front];
		int count = map[k]+1;
		map[k] = count;
		if (k == m){
			ans++;
		}
		if (k+1<=100000 && map[k+1] == 0){
			stack[rear++] = k+1;
		}
		if (k-1>=0 && map[k-1] == 0){
			stack[rear++] = k-1;
		}
		if (k*2<=100000 && map[k*2] ==0){
			stack[rear++] = k*2;
		}
		front = front + 1;
	}
	printf("%d\n", map[m]);
	printf("%d", ans);
}


