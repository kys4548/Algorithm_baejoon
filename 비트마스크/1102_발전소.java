import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class Main {
	static int N;
	static int P;
	static int[][] d;
	static int[][] maps;
	static final int MAX = 987654321;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		maps = new int[N][N];
		d = new int[N][(1 << N) -1];
		int bit = 0;
		int count = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(d[i], MAX);
		}
		StringBuilder sb = new StringBuilder(br.readLine());
		char[] arr = sb.reverse().toString().toCharArray();
		
		for(char c : arr) {
			bit = bit << 1;
			if(c == 'Y') {
				bit += 1;
				count++;
			}
		}
		P = Integer.parseInt(br.readLine());
		if(P == 0) {
			System.out.println(0);
			return;
		}
		if(count == 0) {
			System.out.println(-1);
			return;
		}
		int answer = solve(0, bit, count);
		System.out.println(answer);
	}
	
	public static int solve(int cur, int bit, int count) {
		//base case
		if(count >= P) {
			return 0;
		}
		
		if(d[cur][bit] != MAX) {
			return d[cur][bit];
		}
		
		for(int i=0; i<N; i++) {
			// i : 켜진 발전소, j : 꺼진 발전소
			if((bit & (1 << i)) == (1 << i)) {
				for(int j=0; j<N; j++) {
					if((bit & (1 << j)) == (1 << j)) {
						continue;
					}
					d[cur][bit] = Math.min(d[cur][bit], maps[i][j] + solve(j, bit | (1<<j), count+1));
				}
			}
		}
		
		return d[cur][bit];
	}
}