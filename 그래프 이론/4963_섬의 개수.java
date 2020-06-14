import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0) {
				break;
			}
			
			int[][] maps = new int[N][M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					maps[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			boolean[][] visited = new boolean[N][M];
			int answer = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(maps[i][j] == 1 && visited[i][j] == false) {
						solve(maps, i, j, N, M, visited);
						answer++;
					}
				}
			}
			System.out.println(answer);
		}
	}
	
	private static void solve(int[][] maps, int a, int b, int N, int M, boolean[][] visited) {
		//base case
		if(a < 0 || a >= N || b < 0 || b >= M || maps[a][b] == 0 || visited[a][b] == true) {
			return;
		}
		visited[a][b] = true;
		
		solve(maps, a-1, b-1, N, M, visited);
		solve(maps, a-1, b, N, M, visited);
		solve(maps, a-1, b+1, N, M, visited);
		solve(maps, a, b-1, N, M, visited);
		solve(maps, a, b+1, N, M, visited);
		solve(maps, a+1, b-1, N, M, visited);
		solve(maps, a+1, b, N, M, visited);
		solve(maps, a+1, b+1, N, M, visited);
	}
}