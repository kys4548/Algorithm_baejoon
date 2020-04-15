import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][10];
        for(int i=0; i<10; i++) {
            dp[1][i] = 1;
        
        }

        for(int i=1; i<N; i++) {
            for(int j=0; j<10; j++) {
                for(int k=9; k>=j; k--) {
                    dp[i+1][k] += dp[i][j]; 
                }
                dp[i+1][j] %= 10007;
            }
        }
        int answer = 0;
        for(int i=0; i<10; i++) {
            answer += dp[N][i];
        }
        answer %= 10007;
        System.out.print(answer);
    }
}