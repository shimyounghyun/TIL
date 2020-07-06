function solution(n, times) {    
    var max = Number.MAX_SAFE_INTEGER;
    var answer = max;
    var min = 1;
    var mid = Math.floor((max + min) / 2);
    while (min <= max)
    {
        var res = times.reduce((acc, curr)=>acc + Math.floor(mid/curr),0);
        if (res < n)
            min = mid + 1;
        else if(res >= n)
            max = mid - 1;
        mid = Math.floor((max + min) / 2);
    }
    return min;
}