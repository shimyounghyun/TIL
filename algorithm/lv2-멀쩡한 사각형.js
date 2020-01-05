function solution(w,h){
    let box = 0;
    for(let i = 0; i < w; i++){
        box += Math.ceil(h / w * (i + 1)) - Math.floor(h/w * i)
    }
	return w == 1 || h == 1 ? 0 : w * h - box;
}