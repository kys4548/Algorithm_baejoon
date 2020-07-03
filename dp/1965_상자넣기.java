import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] =  Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for(int i=0; i<n; i++) {
            int idx = Arrays.binarySearch(dp, arr[i]);
            if(idx < 0) {
                idx = -(idx +1);
            }
            dp[idx] = arr[i];
            if(answer < idx) {
                answer = idx;
            }
        }
        //System.out.println(Arrays.toString(dp));
        System.out.println(answer+1);
    }
}