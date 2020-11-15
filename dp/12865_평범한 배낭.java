import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Good[] goods = new Good[n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            goods[i] = new Good(weight, value);
        }

        int[][] dp = new int[n+1][k+1];

        for(int i=0; i<n; i++) {
            for(int j=0; j<=k; j++) {
                if(j < goods[i].weight) {
                    dp[i+1][j] = dp[i][j];
                    continue;
                }
                dp[i+1][j] = Math.max(dp[i][j], dp[i][j-goods[i].weight] + goods[i].value);
            }
        }

        System.out.println(dp[n][k]);
    }
}

class Good {
    int weight;
    int value;

    public Good(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}