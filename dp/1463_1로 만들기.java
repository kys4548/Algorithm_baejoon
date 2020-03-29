import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if(N <= 3) {
            System.out.print(N/2);
            return;
        }
        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[2] = 1;
        dp[3] = 1;

        for(int i=4; i<=N; i++) {
            if(i % 6 == 0) {
                dp[i] = Math.min( Math.min(dp[i-1], dp[i/2]), dp[i/3]) + 1;
            }
            else if(i % 3 == 0) {
                dp[i] = Math.min(dp[i-1], dp[i/3]) + 1;
            } 
            else if(i % 2 == 0) {
                dp[i] = Math.min(dp[i-1], dp[i/2]) + 1;
            }
            else {
                dp[i] = dp[i-1] + 1;
            }
        }
        System.out.print(dp[N]);
        br.close();
    }
}