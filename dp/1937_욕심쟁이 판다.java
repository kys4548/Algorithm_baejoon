import java.io.*;
import java.util.*;

class Main {
	static int n;
	static int[][] maps;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		maps = new int[n][n];
		dp = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				solve1(i, j);
			}
		}
		
		int answer = 1;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(dp[i][j] != 0) {
					continue;
				}
				answer = Math.max(answer, solve2(i,j, 0));
			}
		}
		System.out.println(answer);
	}
	
	public static void solve1(int a, int b) {
		if((a > 0 && maps[a-1][b] > maps[a][b]) || (a < n-1 && maps[a+1][b] > maps[a][b]) ||
		   (b > 0 && maps[a][b-1] > maps[a][b]) || (b < n-1 && maps[a][b+1] >maps[a][b])){
			return;
		}
		dp[a][b] = 1;
	}
	
	public static int solve2(int a, int b, int value) {
		//base case
		if(a < 0 || a >= n || b < 0 || b >= n || value >= maps[a][b]) {
			return 0;
		}
		if(dp[a][b] != 0) {
			return dp[a][b];
		}
		
		dp[a][b] = Math.max(Math.max(solve2(a-1, b, maps[a][b]), solve2(a+1, b, maps[a][b])), Math.max(solve2(a,b-1, maps[a][b]), solve2(a,b+1, maps[a][b]))) + 1;
		return dp[a][b];
		
		
	}
}