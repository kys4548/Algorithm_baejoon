import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] rgbCost  = new int[N][3];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                rgbCost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=1; i<N; i++) {
            rgbCost[i][0] += Math.min(rgbCost[i-1][1],rgbCost[i-1][2]);
            rgbCost[i][1] += Math.min(rgbCost[i-1][0],rgbCost[i-1][2]);
            rgbCost[i][2] += Math.min(rgbCost[i-1][0],rgbCost[i-1][1]);
        }

        int answer = Math.min( Math.min(rgbCost[N-1][0], rgbCost[N-1][1]), rgbCost[N-1][2]);
        System.out.print(answer);
    }
}