import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class Main {
	
	static int n = 0;
	static int m = 0;
	static final int DIVIDE = 9901;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] dp = new int[n*m+1][1 << n];
		for(int i=1; i<=n*m; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		
		int answer = solve(1, 0, dp);
		System.out.println(answer);
	}
	
	public static int solve(int tileNum, int bit, int[][] dp) {
		if(tileNum == n * m) {
			if((bit & 1)  == 0) {
				dp[tileNum][bit] = 0;
			} else {
				dp[tileNum][bit] = 1;
			}
			return dp[tileNum][bit];
		}
		
		if(dp[tileNum][bit] != -1) {
			return dp[tileNum][bit];
		}
		
		if((bit & 1) == 1) {
			return solve(tileNum+1, bit >> 1, dp);
		}
		
		int result = 0;
		
		if(tileNum % n > 0 && (bit & 3) == 0) {
			result += solve(tileNum + 1, (bit >> 1) | 1, dp);
		}
		
		if(tileNum <= n * (m-1)) {
			result += solve(tileNum + 1, (bit >> 1) | (1 << n-1), dp);
		}
		
		dp[tileNum][bit] =  result % DIVIDE;
		return dp[tileNum][bit];
	}
}