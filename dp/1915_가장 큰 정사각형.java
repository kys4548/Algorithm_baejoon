import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] maps = new int[n][m];

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int j=0; j<m; j++) {
                maps[i][j] = s.charAt(j) -'0';
            }
        }

        int answer = 0;
        boolean find = false;

        for(int i=0; i<m; i++) {
            if(maps[0][i] == 1) {
                answer = 1;
                find = true;
                break;
            }
        }
        if(find == false) {
            for(int i=0; i<n; i++) {
                if(maps[i][0] ==1 ){
                    answer = 1;
                    break;
                }
            }
        }

        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(maps[i][j] == 0) {
                    continue;
                }
                maps[i][j] += Math.min(Math.min(maps[i-1][j-1], maps[i-1][j]), maps[i][j-1]);
                if(answer < maps[i][j]) {
                    answer = maps[i][j];
                }
            }
        }
        System.out.println(answer*answer);
    }

}