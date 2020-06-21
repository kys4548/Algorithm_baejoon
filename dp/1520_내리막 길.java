import java.io.*;
import java.util.*;

class Main {
	static int n;
	static int m;
	static int[][] maps;
	static int[][] dp; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		maps = new int[n][m];
		dp = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(dp[i], -1);
		}
		int answer = solve(0, 0, Integer.MAX_VALUE);
		System.out.println(answer);
	}
	
	public static int solve(int a, int b, int preHeight) {
		//base case
		if(a < 0 || a >=n || b < 0 || b >= m || preHeight <= maps[a][b]) {
			return 0;
		}
		if(a == n-1 && b == m-1) {
			return 1;
		}
		
		//dp
		if(dp[a][b] != -1) {
			return dp[a][b];
		}
		
		dp[a][b] = solve(a-1, b, maps[a][b]) + solve(a, b-1, maps[a][b]) 
				   + solve(a+1, b, maps[a][b]) + solve(a, b+1, maps[a][b]);
		
		return dp[a][b];
	}
}