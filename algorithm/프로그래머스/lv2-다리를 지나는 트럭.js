function solution(bridge_length, weight, truck_weights){
    let time = 0;
    const bridge = [];
    do{
        time++;
        
        if(bridge[0] && bridge[0].end == time){
            bridge.shift();
        }

        if(bridge.reduce((x,y)=>x+y.weight,0)+truck_weights[0] <= weight ){            
            bridge.push({weight:truck_weights.shift(), end:time+bridge_length})            
        }
        
        
    }while(bridge.length)

    return time;
}