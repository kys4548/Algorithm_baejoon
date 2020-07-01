import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[t];
        int max = -1;

        for(int i=0; i<t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i]) {
                max = arr[i];
            }
        }

        int[][] dp = new int[max+1][max+1];
        boolean[] isOpen = new boolean[max+1];

        for(int i=1; i<=max; i++) {
            for(int j=1; j<=max; j++) {
                if(j % i == 0) {
                    isOpen[j] = !isOpen[j];
                }
                if(isOpen[j] == true) {
                    dp[i][j] = 1;
                }
            }
        }

        for(int i=0; i<t; i++) {

            int answer = 0;
            for(int j=1; j<=arr[i]; j++) {
                answer += dp[arr[i]][j];
            }
            System.out.println(answer);
        }

    }
}
