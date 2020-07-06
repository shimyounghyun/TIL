
function solution(progresses, speeds) {
    const answer = [];
    let stack = [];
    const completeDay = progresses.map((v, i)=>Math.ceil((100 - v)/speeds[i]))
    
    for(const v of completeDay){
        if(stack.length >= 1 && stack[0] < v){
            // console.log(stack)
            answer.push(stack.length);
            stack = [];            
        }
        stack.push(v);
        // console.log(stack)
    }
    
    if(stack.length) answer.push(stack.length);
    
    return answer;
}


