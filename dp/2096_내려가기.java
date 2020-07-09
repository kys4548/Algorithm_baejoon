import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int dpMax[][] = new int[n+1][3];
        int dpMin[][] = new int[n+1][3];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                int addMax = -1;
                int addMin = -1;

                if(j == 0) {
                    addMax = Math.max(dpMax[i-1][0], dpMax[i-1][1]);
                    addMin = Math.min(dpMin[i-1][0], dpMin[i-1][1]);
                } else if(j == 1) {
                    addMax = Math.max(Math.max(dpMax[i-1][0], dpMax[i-1][1]), dpMax[i-1][2]);
                    addMin = Math.min(Math.min(dpMin[i-1][0], dpMin[i-1][1]), dpMin[i-1][2]);
                } else {
                    addMax = Math.max(dpMax[i-1][1], dpMax[i-1][2]);
                    addMin = Math.min(dpMin[i-1][1], dpMin[i-1][2]);

                }
                int value = Integer.parseInt(st.nextToken());
                dpMax[i][j] = value + addMax;
                dpMin[i][j] = value + addMin;
            }
        }

        int resultMax = Math.max(Math.max(dpMax[n][0], dpMax[n][1]), dpMax[n][2]);
        int resultMin =  Math.min(Math.min(dpMin[n][0], dpMin[n][1]), dpMin[n][2]);
        System.out.println(resultMax + " " + resultMin);
    }
}