import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	static int[][] d;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];
		
		for(int i=0; i<T; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(N < arr[i]) {
				N = arr[i];
			}
		}
		
		d = new int[4*N+1][(1<<4)];
		for(int i=0; i<=4*N; i++) {
			Arrays.fill(d[i], -1);
		}
		solve(1, 0);
		
		for(int i=0; i<T; i++) {
			System.out.println(d[(N-arr[i])*4+1][0]);
		}
		
	}
	
	public static int solve(int cur, int state) {
		 //base case
		 if(cur == 4* N) {
		 	if((state & 1) == 1) {
		 		return 1;
		 	} else {
		 		
		 	}
		 	return 0;
		 }
		 
		 if(d[cur][state] != -1) {
		 	return d[cur][state];
		 }
		 
		 if((state & 1) ==  1) {
		 	return solve(cur+1, state>>1);
		 }
		 
		 if((cur % 4 != 0 && (state & (1<<1)) == 0) && cur <= 4 * (N-1)) {
		 	d[cur][state] = solve(cur+1, (state>>1) | (1<<0)) + solve(cur+1, (state>>1) | (1<<3));
		 } else if(cur % 4 != 0 && (state & (1<<1)) == 0){
		 	d[cur][state] = solve(cur+1, (state>>1) | (1<<0));
		 } else if(cur <= 4 * (N-1)) {
		 	d[cur][state] = solve(cur+1, (state>>1) | (1<<3));
		 } else {
		 	d[cur][state] = 0;
		 }
		 return d[cur][state];
	}
}