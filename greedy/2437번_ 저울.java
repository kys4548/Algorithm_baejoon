import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        int answer = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(arr);
		if(arr[0] != 1) {
			System.out.println(answer);
			return;
		}
		int index = -1;
		for(int i=0; i<N-1; i++) {
			if(arr[i+1] - arr[i] > 1) {
				index = i;
				break;
			}
			arr[i+1] += arr[i];
		}
		if(index == -1) {
			answer = arr[N-1] +1;
		}
		else {
			answer = arr[index] +1;
		}
        System.out.println(answer);
        br.close();
    }
}