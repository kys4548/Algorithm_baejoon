import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		int[][] maps = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int last = N * M;
		
		for(int i=0; i<last; i++) {
			int firstRow = i / M;
			int firstCol = i % M;
			if(maps[firstRow][firstCol] != 0) {
				continue;
			}
			for(int j=i+1; j<last; j++) {
				int secondRow = j / M;
				int secondCol = j % M;
				if(maps[secondRow][secondCol] != 0) {
					continue;
				}
				for(int k=j+1; k<last; k++) {
					int thirdRow = k / M;
					int thirdCol = k % M;
					if(maps[thirdRow][thirdCol] != 0) {
						continue;
					}
					int[][] tempMaps = new int[N][M];
					for(int a=0; a<N; a++) {
						for(int b=0; b<M; b++) {
							tempMaps[a][b] = maps[a][b];
						}
					}
					
					tempMaps[firstRow][firstCol] = 1;
					tempMaps[secondRow][secondCol] = 1;
					tempMaps[thirdRow][thirdCol] = 1;
					
					boolean[][] visited = new boolean[N][M];
					for(int a=0; a<N; a++) {
						for(int b=0; b<M; b++) {
							if(tempMaps[a][b] == 2)
							infection(a, b, N, M, tempMaps, visited);
						}
					}
					int safeArea = 0;
					for(int a=0; a<N; a++) {
						for(int b=0; b<M; b++) {
							if(tempMaps[a][b] == 0) {
								safeArea++;
							}
						}
					}
					answer = Math.max(answer, safeArea);
				}
			}
		}
		System.out.println(answer);
	}
	
	public static void infection(int a, int b, int N, int M, int[][] tempMaps, boolean[][] visited) {
		if(a < 0 || a >= N || b < 0 || b >= M || visited[a][b] == true) {
			return;
		}
		
		visited[a][b] = true;
		if(tempMaps[a][b] == 1) {
			return;
		}
		tempMaps[a][b] = 2;
		
		infection(a-1, b, N, M, tempMaps, visited);
		infection(a, b+1, N, M, tempMaps, visited);
		infection(a+1, b, N, M, tempMaps, visited);
		infection(a, b-1, N, M, tempMaps, visited);
	}
}