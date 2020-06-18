import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n %2 != 0) {
			System.out.println(0);
			return;
		}
		if(n == 2) {
			System.out.println(3);
			return;
		}
		int[] dp = new int[n+1];
		dp[2] = 3;
		dp[4] = 11;
		
		for(int i=6; i<=n; i += 2) {
			dp[i] = 4 * dp[i-2] - dp[i-4];
		}
		
		System.out.println(dp[n]);
	}
}