import java.util.*;

public class Main {
	public static class Node{
		int y;
		int x;
		int day;
		int num;
		
		public Node(int y, int x, int day, int num) {
			this.y=y;
			this.x=x;
			this.day=day;
			this.num=num;
		}
	}
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	static boolean[][] visit;
	static int[][] map;
	static int[][] area;
	static int[][] dist;
	static Queue<Node> list = new LinkedList<>();
	
	public static void makeArea(int y, int x, int areaNum) {
		int n = map[y][x];
		boolean isEdge = false;
		for (int i=0; i<4; i++) {
			if (y+dy[i] < 0 || y+dy[i] >= map.length
				|| x+dx[i] < 0 || x+dx[i] >= map.length
				|| visit[y+dy[i]][x+dx[i]])
				continue;
			if (map[y+dy[i]][x+dx[i]] == 0) { 
				isEdge = true;
				continue;
			}
			area[y+dy[i]][x+dx[i]] = areaNum;
			visit[y+dy[i]][x+dx[i]] = true;
			makeArea(y+dy[i], x+dx[i], areaNum);
		}
		if (isEdge) list.add(new Node(y, x, 0, areaNum));
	}
	
	public static void makeDist() {
		int min = 1000000;
		
		while (!list.isEmpty()) {
			Node node = list.poll();
			int y= node.y;
			int x = node.x;
			for (int i=0; i<4; i++) {
				if (y+dy[i] < 0 || y+dy[i] >= map.length
					|| x+dx[i] < 0 || x+dx[i] >= map.length)
					continue;
				if ( visit[y+dy[i]][x+dx[i]] 
								&& area[y+dy[i]][x+dx[i]] != node.num) {
					min = Math.min(min, dist[y+dy[i]][x+dx[i]]+node.day);
					continue;
				}
				if (dist[y+dy[i]][x+dx[i]] >= 1 || visit[y+dy[i]][x+dx[i]]) continue;
				visit[y+dy[i]][x+dx[i]] = true;
				area[y+dy[i]][x+dx[i]] = node.num;
				dist[y+dy[i]][x+dx[i]] = node.day+1;
				list.add(new Node(y+dy[i], x+dx[i], node.day+1, node.num));
			}
		}
		System.out.println(min);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		map = new int[size][size];
		
		for (int i=0; i<size; i++){
			String[] row = sc.nextLine().split(" ");
			for (int j=0; j<size; j++){
				map[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		visit = new boolean[size][size];
		area = new int[size][size];
		dist = new int[size][size];
		int areaSize = 1;
		
		for (int i=0; i<size; i++){
			for (int j=0; j<size; j++){
				if (map[i][j] == 1 && visit[i][j] == false) {
					makeArea(i, j, areaSize);
					areaSize++;
				}
			}
		}
		makeDist();
	}
}
