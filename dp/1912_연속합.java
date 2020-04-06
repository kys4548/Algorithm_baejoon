import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp = new int[n];
        for(int i=0; i<n; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        int answer = dp[0];

        for(int i=1; i<n; i++) {
            if(dp[i-1] > 0) {
                dp[i] += dp[i-1];
            }
            answer = Math.max(answer, dp[i]);
        }
        
        System.out.print(answer);
    }
}