function solution(w,h){
    let box = 0;
    for(let i = 0; i < w; i++){
        box += h - (Math.ceil((h / w).toFixed(5) * (i + 1)) - Math.floor((h / w).toFixed(5) * i))
    }
	return box;
}