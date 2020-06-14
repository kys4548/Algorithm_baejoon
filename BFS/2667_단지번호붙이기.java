import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<Integer>();
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				if(s.charAt(j) == '1') {
					map[i][j] = 1;
				}
			}
		}
		
		int count = 0;
		boolean[][] visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != 1 || visited[i][j] == true) {
					continue;
				}
				list.add(solve(map, i, j, N, visited));
				count++;
			}
		}
		
		Collections.sort(list);
		System.out.println(count);
		for(int num : list) {
			System.out.println(num);
		}
	}
	
	private static int solve(int[][] map, int a, int b, int N, boolean[][] visited) {
		//base case
		if(a<0 || a >=N || b<0 || b>=N || map[a][b] != 1 || visited[a][b] == true) {
			return 0;
		}
		visited[a][b] = true;
		
		
		return solve(map, a-1, b, N, visited) + solve(map, a+1, b, N, visited) + 
			solve(map, a, b-1, N, visited) + solve(map, a, b+1, N, visited) + 1;
	}
}