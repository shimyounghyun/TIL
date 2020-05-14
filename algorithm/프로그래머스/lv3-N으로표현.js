var dp = {};
function solution(N, number) {
	var count = 1;
    
    dp[count++] = [N];
    if (N == number)
        return 1;
    while (count <= 8){
        if (dp[count-1][0] * 10 + N == number)
            return count;
        dp[count] = [dp[count-1][0] * 10 + N];
        for (var i=1; i<count; i++){
            for (var j=0; j<dp[i].length; j++){
            	var n = dp[i][j];
            	for (var k=0; k<dp[count-i].length; k++){
            		var m = dp[count-i][k];
                    if (n+m == number || n-m == number || n*m == number)
                        return count;
                    dp[count].push(n+m);
                    dp[count].push(n-m);
                    dp[count].push(n*m);
                    if (m){
                        if (parseInt(n/m) == number)
                            return count;
                    	dp[count].push(parseInt(n/m));
                    }
                }    
            }
        }
        count++;
    }
    return -1;
}
