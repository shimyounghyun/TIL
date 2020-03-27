#include <stdio.h>

int t[100000];

int main()
{
	int n,m;
	scanf("%d %d", &n, &m);
	int name = 1;
	int index = 0;
	for(int i=0; i<n; i++)
	{
		int time;
		scanf("%d", &time);
		for (int j=0; j<time; j++)
			t[index++] = name;
		name++;
	}

	for(int i=0; i<m; i++)
	{
		int c;
		scanf("%d", &c);
		printf("%d\n", t[c]);
	}
}
