const getTotalTime = (hour, min, sec) => 
    hour * 3600 * 1000 + min * 60 * 1000 + sec * 1000;

const MAX = (a, b) => a > b ? a : b;

function solution(lines) {
    var answer = 0;
    var start = [];
    var end = [];
    var length = lines.length;
    
    for (const time of lines){
        var split_time = time.split(" ");
        if (split_time[0] != "2016-09-15") continue;
        var end_time = getTotalTime(...split_time[1].split(":"));
        var proc_time = split_time[2].replace("s", " ") * 1000;
        var start_time = end_time - proc_time + 1;
        start.push(start_time);
        end.push(end_time);
    }
    
    for (var i=0; i<length; i++){
        var result_count = 0;
        var start_count = 0;
        var end_count = 0;
        for (var j=0; j<length; j++){
            if (start[i] <= end[j] && start[i]+999 >= start[j])
                start_count++;
            if (end[i] <= end[j] && end[i]+999 >= start[j])
                end_count++;
        }
        var result_count = MAX(start_count, end_count);
        if (answer < result_count)
            answer = result_count;
    }
    
    return answer;
}