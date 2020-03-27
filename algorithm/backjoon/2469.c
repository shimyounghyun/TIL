#include <stdio.h>
#include <stdlib.h>

int n;
int m;
int up[26];
int down[26];
char map[1000][26];
char result[25];

void print()
{
	for (int i=0; i<m; i++)
	{
		for (int j=0; j<n; j++)
			printf("%c", map[i][j]);
		printf("\n");
	}
	printf("\n");
}

void printUp()
{
	for(int i=0; i<n; i++)
		printf("%d", up[i]);
	printf("\n");
}

void printDown()
{
	for(int i=0; i<n; i++)
		printf("%d", down[i]);
	printf("\n");
}

void init()
{
	for(int i=0; i<26; i++)
		up[i] = i;
}

int main()
{
	scanf("%d", &n);
	scanf("%d", &m);
	for(int i=0; i<=n; i++)
	{
		char c = getchar();
		if (c != '\n')
			down[i-1] = c - 'A';
	}
	init();	
	int ran = -1;
	for (int i=0; i<m; i++)
	{
		char s[n];
		scanf("%s", s);
		if (s[0] == '?')
			ran = i;
		for (int j=0; j<n; j++)
			map[i][j] = s[j];
		if (ran == -1)
		{
			for(int j=0; j<n; j++)
			{
				char c = map[i][j];
				if (c == '-')
				{
					int temp = up[j];
					up[j] = up[j+1];
					up[j+1] = temp;
				}
			}
		}
	}
	
	for (int i=m-1; i>ran; i--)
	{
		for(int j=0; j<n; j++)
		{
			char c = map[i][j];
			if (c == '-')
			{
				int temp = down[j];
				down[j] = down[j+1];
				down[j+1] = temp;
			}
		}
	}
	int diff=0;
	for(int i=0; i<n-1; i++)
	{
		if (up[i] == down[i])
			result[i] = '*';
		else if(up[i] == down[i+1] && up[i+1] == down[i])
		{
			result[i++] = '-';
			result[i]='*';
		}
		else
		{
			for(int j=0;j<n-1;j++)
				printf("x");
			diff=1;
			break;
		}
	}
	if (diff != 1)
	{
		for(int j=0; j<n-1; j++)
			printf("%c", result[j]);
	}
}
