import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int answer = 0;
		
		while(input[0] + input[1] -3 >= input[2]) {
			if(input[0] < 2 || input[1] <1) {
				break;
			}
			input[0] -=2;
			input[1]--;
			answer++;
		}
		System.out.println(answer);
	}
}