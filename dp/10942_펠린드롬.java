import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[][] dp = new int[n+1][n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i][i] = 1;
        }

        for(int i=1; i<n; i++) {
            if(arr[i] == arr[i+1]) {
                dp[i][i+1] = 1;
            }
        }

        for(int i=3; i<=n; i++) {
            for(int j=1; j<=n-i +1; j++) {
                if(dp[j+1][i+j-2] ==1 && arr[j] == arr[i+j-1]) {
                    dp[j][i+j-1] = 1;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write(dp[start][end] + "\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}