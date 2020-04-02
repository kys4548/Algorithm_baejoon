import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N+1];
        for(int i=0; i<N; i++) {
            score[i+1] = Integer.parseInt(br.readLine());
        }

        if(N == 1) {
            System.out.print(score[1]);
            return;
        }
        if(N == 2) {
            System.out.print(score[1] + score[2]);
            return;
        }
        if(N == 3) {      
            System.out.print(Math.max(Math.max(score[1] + score[2], score[1] + score[3]), score[2] + score[3]));
            return;
        }
        int[] dp = new int[N+1];
        dp[1] = score[1];
        dp[2] = score[2];

        for(int i=3; i<N; i++) {
            dp[i] = Math.max(dp[i-3] + score[i-2] + score[i], dp[i-2] + score[i]);
        }

        int answer = Math.max(Math.max(dp[N-3]+score[N-2], dp[N-2]), dp[N-1]) + score[N];

        System.out.println(answer);
    }

}