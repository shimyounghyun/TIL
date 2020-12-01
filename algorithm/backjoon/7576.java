import java.util.*;

public class Main {
	public static class Node implements Comparable<Node>{
		int y;
		int x;
		int day;
		
		public Node(int y, int x, int day) {
			this.y=y;
			this.x=x;
			this.day=day;
		}
		
		public int compareTo(Node n) {
			return Integer.compare(this.day, n.day);
		}
	}
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] info = sc.nextLine().split(" ");
		int m = Integer.parseInt(info[0]);
		int n = Integer.parseInt(info[1]);
		int[][] map = new int[n][m];
		 
		PriorityQueue<Node> q = new PriorityQueue<>();
		int total = n*m;
		for (int i=0; i<n; i++){
			String[] row = sc.nextLine().split(" ");
			for (int j=0; j<m; j++){
				map[i][j] = Integer.parseInt(row[j]);
				if (map[i][j] == 1) q.add(new Node(i, j, 0));
				if (map[i][j] == -1) total--;
			}
		}
		
		if (q.isEmpty()) {
			System.out.println(-1);
			return;
		}
		
//		for (int i=0; i<n; i++){
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		int result = 0;
		while (!q.isEmpty()) {
			Node node = q.poll();
			total--;
			for (int i=0; i<4; i++) {
				if (dy[i]+node.y < 0 || dy[i]+node.y >= n
					|| dx[i]+node.x < 0 || dx[i]+node.x >= m
					|| map[dy[i]+node.y][dx[i]+node.x] != 0 ) continue;
				q.add(new Node(dy[i]+node.y, dx[i]+node.x, node.day+1));
				map[dy[i]+node.y][dx[i]+node.x] = 1;
				result = node.day+1;
			}
		}
		if (total != 0) {
			System.out.println(-1);
			return;
		}
		System.out.println(result);
	}
}
