import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				if(s.charAt(j) == '1') {
					map[i][j] = 1;
				}
			}
		}
		
		boolean[][] visited = new boolean[N][M];
		List<Point> list = new ArrayList<Point>();
		list.add(new Point(0,0));
		visited[0][0] = true;
		solve(map, list, N, M, visited, 1);
	}
	
	public static void solve(int[][] map, List<Point> list, int N, int M, boolean[][] visited, int count) {
		List<Point> nextList = new ArrayList<Point>();
		
		while(!list.isEmpty()) {
			Point p = list.remove(0);
			if(p.a == N-1 && p.b == M-1) {
				System.out.println(count);
				return;
			}
			if(p.a< 0 || p.a >= N || p.b < 0 || p.b >= M || map[p.a][p.b] == 0) {
				continue;
			}
			
			if(p.a-1 >= 0 && visited[p.a-1][p.b] == false) {
				nextList.add(new Point(p.a-1, p.b));
				visited[p.a-1][p.b] = true;
			}
			if(p.a+1 < N && visited[p.a+1][p.b] == false) {
				nextList.add(new Point(p.a+1, p.b));
				visited[p.a+1][p.b] = true;
			}
			if(p.b-1 >= 0 && visited[p.a][p.b-1] == false) {
				nextList.add(new Point(p.a, p.b-1));
				visited[p.a][p.b-1] = true;
			}
			if(p.b+1 < M && visited[p.a][p.b+1] == false) {
				nextList.add(new Point(p.a, p.b+1));
				visited[p.a][p.b+1] = true;
			}
		}
		solve(map, nextList, N, M, visited, count+1);
	}
}

class Point {
	int a;
	int b;
	
	Point(int a, int b) {
		this.a = a;
		this.b = b;
	}
}