#include <stdio.h>
int mem[41] = {0, 1, 1,};
int fibonacci(int n) {
    if (n <= 0) {
        return 0;
    }else if(mem[n]){ 
		return mem[n];
	}else {
        return mem[n] = (fibonacci(n-1) + fibonacci(n-2));
    }
}
int main()
{
	int n;
	scanf("%d", &n);
	for (int i=0; i<n; i++)
	{
		int num;
		scanf("%d", &num);
		if(num == 0)
			printf("%d %d\n",1,0);
		else if(num == 1)
			printf("%d %d\n",0,1);
		else
		{
			fibonacci(num);
			printf("%d %d\n",mem[num-1], mem[num]);
		}
	}
	return 0;
}
