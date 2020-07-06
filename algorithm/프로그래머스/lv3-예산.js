function check(arr, n){
    let result = 0;
    for (const v of arr)
    {
        if (v > n)
            result += n;
        else
            result += v;
    }
    return result;
}
function solution(budgets, M) {
    var max = Math.max.apply(null, budgets);
    var size = budgets.length;
    var start = 0;
    var end = max;
    var mid = (Math.floor((start + end) / 2));
    while (start <= end)
    {        
        var result = check(budgets, mid);
        if(result > M)
            end = mid - 1;
        else if(result < M)
            start = mid + 1;
        else
            return mid;
        mid = Math.floor((start + end) / 2);
    }
    return mid;
}