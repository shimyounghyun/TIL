long long solution(int n) {
    long long a = 1;
    long long b = 1;
   long long temp = 0; 
    if ( n == 1)
        return (1);
    for (int i=2; i<=n; i++)
    {
        temp = (a + b) % 1234567;
        a = b;
        b = temp;
	}
    return b;
}
