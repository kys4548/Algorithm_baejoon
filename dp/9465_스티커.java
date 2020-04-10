import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N];

            for(int j=0; j<2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0; k<N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            if(N == 1) {
                System.out.print(Math.max(arr[0][0], arr[1][0]));
                return;
            }
            if(N == 2) {
                System.out.print(Math.max(arr[0][0]+arr[1][1], arr[1][0]+arr[0][1]));
                return;
            }
            arr[0][1] += arr[1][0];
            arr[1][1] += arr[0][0];

            for(int j=2; j<N; j++) {
                arr[0][j] += Math.max(arr[1][j-1], arr[1][j-2]);
                arr[1][j] += Math.max(arr[0][j-1], arr[0][j-2]);
            }

            int answer = Math.max(arr[0][N-1], arr[1][N-1]);
            System.out.println(answer);
        }
    }
}