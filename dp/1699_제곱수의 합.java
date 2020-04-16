import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[N+1];
        int sqrt = (int)Math.sqrt(N);  
        for(int i=1; i<=sqrt; i++) {
            dp[i*i] = 1;
        }

        for(int i=1; i<sqrt; i++) {
            for(int j=i*i+1; j<(i+1)*(i+1); j++) {
                int min = 100000;
                for(int k=1; k<=i; k++) {
                    if(min > dp[k*k] + dp[j - k*k]) {
                        min = dp[k*k] + dp[j - k*k];
                    }
                }
                dp[j] = min;
            }
        }
        for(int i=sqrt*sqrt; i<=N; i++) {
            int min = 100000;
            for(int j=1; j<=sqrt; j++) {
                if(min > dp[j*j] + dp[i - j*j]) {
                    min = dp[j*j] + dp[i -j*j];
                }
            }
            dp[i] = min;
        }
        System.out.println(dp[N]);
    }
}