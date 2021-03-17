class MyCalendarThree {
    TreeMap<Integer, Integer> map;

    public MyCalendarThree() {
        this.map = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start,0)+1);
        map.put(end, map.getOrDefault(end,0)-1);
        
        int sum = 0;
        int answer = 0;
        for (int v : map.values()){
            sum += v;
            answer = Math.max(sum, answer);
        }
        return answer;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
