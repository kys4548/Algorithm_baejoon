import java.io.*;
import java.util.*;

class Main {
	
	static int n;
	static int[][] maps;
	static long[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		maps = new int[n][n];
		dp = new long[n][n];
		StringTokenizer st;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(dp[i], -1);
		}
		
		long answer = solve(0,0);
		
		System.out.println(answer);
	}
	
	public static long solve(int a, int b) {
		//base case
		if(a >= n || b >= n) {
			return 0;
		}
		if(a == n-1 && b == n-1) {
			return 1;
		}
		
		//dp
		if(dp[a][b] != -1) {
			return dp[a][b];
		}
		
		if(maps[a][b] == 0) {
			dp[a][b] = 0;
			return dp[a][b];
		}
		
		//전처리?
		long result = 0;
		boolean find;
		
		//recursion
		if(a + maps[a][b] < n) {
			find = true;
			for(int i=a; i<a+maps[a][b]; i++) {
				if(maps[i][b] == 0) {
					find = false;
					break;
				}
			}
			if(find == true) {
				result += solve(a+maps[a][b], b);
			}
		}
		
		if(b + maps[a][b] < n) {
			find = true;
			for(int i=b; i<b+maps[a][b]; i++) {
				if(maps[a][i] == 0) {
					find = false;
					break;
				}
			}
			if(find == true) {
				result += solve(a, b + maps[a][b]);
			}
		}
		dp[a][b] = result;
		
		return dp[a][b];
	}
}