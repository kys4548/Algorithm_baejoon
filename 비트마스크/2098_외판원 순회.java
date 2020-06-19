import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class Main {
	static int[][] maps;
	static int[][] d;
	static int n;
	static int MAX = 987654321;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		maps = new int[n][n];
		d = new int[n][(1 << n)];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(d[i], MAX);
		}
		
		int answer = solve(0, 1);
		System.out.print(answer);
	}
	
	public static int solve(int cur, int visited) {
		//base case
		if(visited == (1<<n) -1) {
            return maps[cur][0] == 0 ? MAX : maps[cur][0];
		}
		
		if(d[cur][visited] != MAX) {
			return d[cur][visited];
		}
		
		
		for(int i=0; i<n; i++) {
			if((visited & (1 << i)) == 0 && maps[cur][i] != 0) {
				d[cur][visited] = Math.min(d[cur][visited], maps[cur][i] + solve(i, visited | (1<<i)));
			} 
		}
		return d[cur][visited];
	}
}