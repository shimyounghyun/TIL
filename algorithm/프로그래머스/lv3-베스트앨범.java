import java.util.*;

class Solution {
    class Song implements Comparable<Song>{
        int id;
        int plays;
        
        public Song(int id, int plays){
            this.id = id;
            this.plays = plays;
        }
        
        @Override
        public int compareTo(Song s){
            if (this.plays == s.plays){
                return this.id - s.id;
            }else{
                return s.plays - this.plays;
            }
        }
    }
    
    class Genre implements Comparable<Genre>{
        int count;
        PriorityQueue<Song> list;
        
        public Genre (){
            this.count = 0;
            this.list = new PriorityQueue<Song>();
        }
        
        public void add(Song song){
            this.list.offer(song);
            this.count += song.plays;
        }
        
        @Override
        public int compareTo(Genre g){
            return  g.count - this.count;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Genre> map = new HashMap<String, Genre>();
        PriorityQueue<Genre> q = new PriorityQueue<Genre>();
        int size = genres.length;        
        for (int i=0; i<size; i++){
            Genre genre = map.get(genres[i]);
            if (genre == null){
                genre = new Genre();
            }
            genre.add(new Song(i, plays[i]));
            map.put(genres[i], genre);
        }
        
        Iterator<String> keys = map.keySet().iterator();
        while (keys.hasNext()){
            String key = keys.next();
            q.offer(map.get(key));
        }
        List<Integer> result = new ArrayList<Integer>();
        while (!q.isEmpty()){
            Genre g = q.poll();
            for (int i=0; i<2; i++){
                if (!g.list.isEmpty()){
                    result.add(g.list.poll().id);
                }
            }
        }
        
        answer = new int[result.size()];
        for (int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
