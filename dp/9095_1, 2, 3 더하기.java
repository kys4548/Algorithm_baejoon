import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[12];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i<12; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        for(int i=0; i<T; i++) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }
}