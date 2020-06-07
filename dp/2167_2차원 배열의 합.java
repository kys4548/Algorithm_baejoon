import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] dp = new int[N+1][M+1];
        int lowsum;
        for(int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());
        	lowsum = 0;
        	for(int j=1; j<=M; j++) {
        		int value = Integer.parseInt(st.nextToken());
        		dp[i][j] = dp[i-1][j] + lowsum + value;
        		lowsum += value;
        	}
        }
        
        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++) {
        	st = new StringTokenizer(br.readLine());
        	int startx = Integer.parseInt(st.nextToken());
        	int starty = Integer.parseInt(st.nextToken());
        	int endx = Integer.parseInt(st.nextToken());
        	int endy = Integer.parseInt(st.nextToken());
        	
        	int result = dp[endx][endy] - dp[startx - 1][endy] - dp[endx][starty - 1] + dp[startx - 1][starty - 1];
        	System.out.println(result);
        }
    }
}