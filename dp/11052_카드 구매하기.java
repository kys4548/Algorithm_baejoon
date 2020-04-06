import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[N];
        
        for(int i=0; i<N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];

        for(int i=0; i<N; i++) {
            dp[i] = input[i];
            for(int j=0; j<i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + input[i-j -1]); 
            }
        }
        System.out.print(dp[N-1]);
    }
}