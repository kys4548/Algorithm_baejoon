import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] amount = new int[n+1];

        for(int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            amount[i] = Integer.parseInt(st.nextToken());
        }
        
        if(n == 1) {
            System.out.print(amount[1]);
            return;
        }
        if(n == 2) {
            System.out.print(amount[1]+ amount[2]);
            return;
        }
        int[] dp = new int[n+1];
        dp[1] = amount[1];
        dp[2] = amount[1] + amount[2];

        for(int i=3; i<=n; i++) {
            dp[i] = Math.max(Math.max(dp[i-3]+amount[i-1]+amount[i], dp[i-2]+amount[i]), dp[i-1]);
        } 
        
        System.out.print(dp[n]);
        
    }
}