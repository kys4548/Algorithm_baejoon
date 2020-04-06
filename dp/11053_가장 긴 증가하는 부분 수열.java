import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        

        int answer = 0;

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(dp[j] > input[i]) {
                    dp[j] = input[i];
                    answer = Math.max(answer, j+1);
                    break;
                } else if (dp[j] == input[i]) {
                    break;
                }
            }

        }
        System.out.print(answer);
    }
}