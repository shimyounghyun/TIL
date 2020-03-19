#include <stdio.h>
#define MIN(a,b) ((a) > (b) ? (b) : (a))
int state[100001];
int copy[100001];
int result[100001];
int n;
void change(int *arr, int i)
{
	for(int j=i-1; j<=i+1; j++)
	{
		if (j >= 0 && j < n)
			arr[j] ^= 1;
	}
}
int main()
{
	scanf("%d", &n);
	for(int i=0; i<n; i++)
	{
		scanf("%1d", &state[i]);
		copy[i] = state[i];
	}
	for(int i=0; i<n; i++)
		scanf("%1d", &result[i]);
	int ans = 1;
	change(state, 0);
	for(int i=1; i<n; i++)
		if (state[i-1] != result[i-1])
		{
			change(state, i);
			ans++;
		}
	for (int i=0; i<n; i++)
		if (state[i] != result[i])
		{
			ans = -1;
			break;
		}
	int ans2 = 0;
	for(int i=1; i<n; i++)
		if (copy[i -1] != result[i -1])
		{
			change(copy, i);
			ans2++;
		}

	for (int i=0; i<n; i++)
		if (copy[i] != result[i])
		{
			ans2 = -1;
			break;
		}
	if (ans == -1 && ans2 == -1)
		printf("%d", -1);
	else
	{
		if (ans == -1 && ans2 != -1)
			printf("%d", ans2);
		else if(ans != -1 && ans2 == -1)
			printf("%d", ans);
		else
			printf("%d", MIN(ans, ans2));
	}
	return 0;
}
