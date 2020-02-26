import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int L = Integer.parseInt(input[1]);
		int[] arr = new int[N];
		input = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(arr);
		int location = -1000000;
		int index = 0;
		while(index < N) {
			if(location+L > arr[index]) {
				index++;
				continue;
			}
			location = arr[index];
			index++;
			answer++;
		}
        
        System.out.println(answer);
        br.close();
    }
}