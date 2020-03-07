#include <stdio.h>
#define ABS(x) ((x < 0) ? -(x) : (x))
int arr[20][20];

void solve(int *team, int size, int index, int target, int *result)
{
	if (index == size / 2){
		int sumA = 0;
		int sumB = 0;
		for (int i=0; i<size; i++)
		{
			for(int j=0; j<size; j++)
			{
				if(i == j) continue;
				if(team[i] == 1 && team[j] == 1)
					sumA += arr[i][j];
				else if(team[i] == 0 && team[j] == 0)
					sumB += arr[i][j];
			}
		}
		if ( *result > ABS(sumA - sumB))
			*result = ABS(sumA - sumB);
	}else if(target == size){
		return ;
	}else{
		while (target < index + size / 2 + 1)
		{
			team[target] = 1;
			solve(team, size, index + 1, target + 1, result);
			team[target] = 0;
			target++;
		}
	}
}

int main()
{
	int n;
	scanf("%d", &n);
	int team[n];
	team[0] = 1;
	for (int i=1; i<n; i++)
		team[i] = 0;
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n; j++)
		{
			scanf("%d", &arr[i][j]);
		}
	}
	int min = 999999999;
	solve(team, n, 1, 1, &min);
	printf("%d", min);
	return 0;
}
