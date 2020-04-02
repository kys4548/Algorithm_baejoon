import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<n; i++) {
            for(int j=0; j<=i; j++) {
                if(j == 0) {
                    dp[i][j] += dp[i-1][j];
                } else if(j == i) {
                    dp[i][j] += dp[i-1][j-1];
                }
                else {
                    dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }

        int answer = 0;
        for(int i=0; i<n; i++) {
            answer = Math.max(answer, dp[n-1][i]);
        }
        System.out.println(answer);
    }
}