import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int[] dp = new int[100];

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        //1 ~ 99 고정값
        for(int i=1; i<100; i++) {
            dp[i] = minCoin(i);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            String s = br.readLine();
            int idx = s.length();
            int answer = 0;

            while(idx > 0) {
                int temp = Integer.parseInt(s.substring(Math.max(0, idx-2), idx));
                answer += dp[temp];
                idx -=2;
            }
            sb.append(answer+"\n");
        }
        System.out.println(sb.toString());
    }

    static int minCoin(int cost) {
        //base case
        if(cost < 0) {
            return 10000;
        }
        if(dp[cost] != 0) {
            return dp[cost];
        }
        if(cost < 10) {
            return cost;
        }

        return Math.min(minCoin(cost- 25) +1, minCoin(cost- 10) +1);
    }
}