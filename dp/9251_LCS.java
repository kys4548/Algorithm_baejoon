import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		int length1 = str1.length();
		String str2 = br.readLine();
		int length2 = str2.length();
		
		int[][] dp = new int[length2+1][length1+1];
		
		for(int i=1; i<=length2; i++) {
			char c = str2.charAt(i-1);
			for(int j=1; j<=length1; j++) {
				dp[i][j] = c == str1.charAt(j-1) ? dp[i-1][j-1] + 1 : Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		System.out.print(dp[length2][length1]);
	}
}