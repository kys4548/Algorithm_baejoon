
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main
{
	static int result = 0;
	
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] sangdam = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sangdam[i][0] = Integer.parseInt(st.nextToken());
			sangdam[i][1] = Integer.parseInt(st.nextToken());
		}
		
		solve(0, N, 0, sangdam);
		System.out.println(result);
	}
	
	public static void solve(int day, int N, int sum, int[][] sangdam) {
		if(day >= N) {
			if(result < sum) {
				result = sum;
			}
			return;
		}
		
		if(day+sangdam[day][0] <= N) {
			solve(day+sangdam[day][0], N, sum + sangdam[day][1], sangdam);
		}
		solve(day+1, N, sum, sangdam);
	}
}