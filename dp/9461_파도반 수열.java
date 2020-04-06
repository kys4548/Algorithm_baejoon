import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for(int i=4; i<=100; i++) {
            dp[i] = dp[i-3] + dp[i-2];
        }
        
        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
        
    }
}