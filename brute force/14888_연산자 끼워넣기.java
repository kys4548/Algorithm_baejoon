import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	private static int min = Integer.MAX_VALUE;
	private static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] number = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] operation = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			operation[i] = Integer.parseInt(st.nextToken());
		}
		solve(number[0], 1, N, number, operation);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void solve(int sum, int count, int N, int[] number, int[] operation) {
		if(count == N) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(operation[i] > 0) {
				operation[i]--;
				switch(i) {
					case 0 :
						solve(sum+number[count], count+1, N, number, operation);
						break;
					case 1 :
						solve(sum-number[count], count+1, N, number, operation);
						break;
					case 2 :
						solve(sum*number[count], count+1, N, number, operation);
						break;
					case 3 :
						solve(sum/number[count], count+1, N, number, operation);
						break;
				}
				operation[i]++;
			}
		}
	}
}