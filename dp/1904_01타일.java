import java.io.*;
import java.util.*;

class Main {
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		Arrays.fill(dp, -1);
		
		int answer = solve(n);
		System.out.println(answer);
	}
	
	public static int solve(int n) {
		//base case
		if(n <= 2) {
			dp[n] = n;
			return dp[n];
		}
		
		//dp
		if(dp[n] != -1) {
			return dp[n];
		}
		
		dp[n] = (solve(n-1) + solve(n-2)) % 15746;
		
		
		return dp[n];
	}
}