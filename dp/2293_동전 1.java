import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] coin = new int[n];
        for(int i=0; i<n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[k+1];
        dp[0] = 1;
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<=k; j++) {
        		if(j+coin[i] > k) {
        			break;
        		}
        		dp[j+coin[i]] += dp[j];
        	}
        }
        System.out.print(dp[k]);
    }
}