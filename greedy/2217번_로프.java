import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		answer = arr[N-1];
		for(int i=N-2; i>=0; i--) {
			if(arr[i] * (N-i) > answer) {
				answer = arr[i] * (N-i);
			}
		}
        
        System.out.println(answer);
        br.close();
    }
}