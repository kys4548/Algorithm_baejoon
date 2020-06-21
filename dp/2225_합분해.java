import java.io.*;
import java.util.*;

class Main {
	static int n;
	static int k;
	static long[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dp = new long[k+1][n+1];
		for(int i=0; i<=k; i++) {
			Arrays.fill(dp[i], -1);
		}
		long answer = solve(0, 0);
		System.out.println(answer);
	}
	
	public static long solve(int count, int sum) {
		if(sum > n) {
			return 0;
		}
		if(count == k) {
			if(sum == n) {
				return 1;
			}
			return 0;
		}
		
		if(dp[count][sum] != -1) {
			return dp[count][sum];
		}
		
		long result = 0;
		for(int i=0; i<=n; i++) {
			result += solve(count+1, sum+i);
		}
		dp[count][sum] = result % 1000000000;
		
		return dp[count][sum];
	}
}