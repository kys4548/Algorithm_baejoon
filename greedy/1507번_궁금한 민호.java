import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] distance = new int[N][N];
		for(int i=0; i<N; i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				distance[i][j] = Integer.parseInt(input[j]);
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if(distance[i][j] == 0) {
					continue;
				}
				boolean isPossibleRemove = false;
				for(int k=0; k<N; k++) {
					if(k==i || k==j || distance[i][k] == 0 || distance[k][j] == 0) {
						continue;
					}
					if(distance[i][j] == distance[i][k] + distance[k][j]) {
						isPossibleRemove = true;
						break;
					}
					if(distance[i][j] > distance[i][k] + distance[k][j]) {
						System.out.println(-1);
						return;
					}
				}
				if(isPossibleRemove ==false) {
					answer += distance[i][j];
				}
			}
		}
        
        System.out.println(answer);
        br.close();
    }
}