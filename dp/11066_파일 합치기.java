import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int[][] dp = new int[n][n];
            int[][] sum = new int[n][n];
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                dp[j][j] = arr[j];
                Arrays.fill(sum[j], Integer.MAX_VALUE);
                sum[j][j] = 0;
            }

            for(int j=0; j<n-1; j++) {
                for(int k=j+1; k<n; k++) {
                    dp[j][k] = dp[j][k-1] + arr[k];
                }
            }

            for(int j=1; j<n; j++) {
                for(int k=0; k<n-j; k++) {
                    for(int l=0; l<j; l++) {
                        sum[k][k+j] = Math.min(sum[k][k+j], sum[k][k+l] + sum[k+l+1][k+j] + dp[k][k+l] + dp[k+l+1][k+j]);
                    }
                }
            }
            System.out.println(sum[0][n-1]);
        }
    }
}