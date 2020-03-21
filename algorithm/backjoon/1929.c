#include <stdio.h>

float _sqrt(const float x)  
{
  union
  {
    int i;
    float x;
  } u;

  u.x = x;
  u.i = (1<<29) + (u.i >> 1) - (1<<22); 
  return u.x;
} 

int isprime(int n)
{
	if ( n == 1)
		return (0);
	if ( n == 2)
		return (1);
	if ( n % 2== 0)
		return (0);
	for (int i=2; i<(int)(_sqrt((float)n)+1);i++)
		if (n % i == 0)
			return (0);
	return (1);
}

int main()
{
	int n, m;
	scanf("%d %d", &n, &m);
	int result = 0;
	for (int i=n; i<=m; i++)
	{
		if (isprime(i))
			printf("%d\n", i);
	}
}
