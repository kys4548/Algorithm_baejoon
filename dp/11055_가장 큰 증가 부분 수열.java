import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp = new int[1001];

        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            int addNum = 0;
            for(int j=num-1; j>=1; j--) {
                if(dp[j] != 0 && addNum < dp[j]) {
                    addNum = dp[j];
                }
            }
            dp[num] = addNum + num;
        }
        int answer = 0;

        for(int i=1; i<=1000; i++) {
            if(dp[i] != 0 && answer < dp[i]) {
                answer = dp[i];
            }
        }
        System.out.println(answer);
    }
}