#include <stdio.h>

int state[100001];
int result[100001];

int main()
{
	int n;
	scanf("%d", &n);
	for (int i=0; i<n; i++)
		scanf("%1d", &state[i]);
	for (int i=0; i<n; i++)
		scanf("%1d", &result[i]);

}
