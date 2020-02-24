import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i=N-1; i>=0; i--) {
			if(arr[i] > K) {
				continue;
			}
			answer += K / arr[i];
			K %= arr[i];
			if(K ==0) {
				break;
			}
		}
 
        System.out.println(answer);
        br.close();
    }
}