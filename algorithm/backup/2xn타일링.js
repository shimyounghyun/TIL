const solution = (n) => {
    let answer = 0;
    let dp = [];
    
    dp[1] = 1;
    dp[2] = 2;
    for (var i=3; i<=n; i++){
        dp[i] = (dp[i-2] + dp[i-1]) % 1000000007;
    }
    
    return dp[n];
}
