import java.io.*;
import java.util.*;

class Main {
	
	static int n;
	static int[][] dp;
	static final int DEVIDE = 9901;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n][3];
		
		for(int i=0; i<n; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		int answer = solve(0, 0);
		System.out.println(answer);
	}
	
	public static int solve(int cur, int state) {
		//base case
		if(cur == n) {
			return 1;
		}
		
		if(dp[cur][state] != -1) {
			return dp[cur][state];
		}
		
		int result = 0;
		
		if(state == 0) {
			result = solve(cur+1, 1) + solve(cur+1, 2);
		} else if(state == 1) {
			result = solve(cur+1, 2);
		} else {
			result = solve(cur+1, 1);
		}
		result += solve(cur+1, 0);
		
		dp[cur][state] = result % DEVIDE;
		
		return dp[cur][state];
	}
}