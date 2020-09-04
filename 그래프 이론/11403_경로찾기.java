import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    final static int INF = 999999999;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] D = new int[n][n]; // 각 점들 사이의 거리, 없을시 INF

        StringTokenizer st = null;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                if(Integer.parseInt(st.nextToken()) == 0) {
                    D[i][j] = INF;   
                } else {
                    D[i][j] = 1;
                }
            }
        }

        //중간경로가 될 수 있는 점들을 늘려나간다.
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    if(D[j][k] > D[j][i] + D[i][k]) {
                        D[j][k] = D[j][i] + D[i][k];
                    }
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(D[i][j] == INF) {
                    System.out.print(0+ " ");
                } else {
                    System.out.print(1 + " ");
                }
            }
            System.out.println();
        }

    }
}