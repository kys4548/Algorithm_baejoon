import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Main {
	
	static int[][] maps = new int[11][11];
	static int[][] d = new int[11][1<<11];
	static final int MIN = -987654321;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			for(int j=0; j<11; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<11; k++) {
					maps[j][k] = Integer.parseInt(st.nextToken());
				}
				Arrays.fill(d[j], MIN);
			}
			sb.append(solve(0, 0)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	public static int solve(int person, int state) {
		//base case
		if(person == 11) {
			return 0;
		}
		
		if(d[person][state] != MIN) {
			return d[person][state];
		}
		
		boolean find = false;
		for(int i=0; i<11; i++) {
			//자리에 배치가능하고 비어있는 경우
			if(maps[person][i] != 0 && (state & (1<<i)) == 0) {
				find = true;
				d[person][state] = Math.max(d[person][state], maps[person][i] + solve(person+1, state | (1<<i)));
			}
		}
		
		if(find == false) {
			d[person][state] += MIN;
		}
		return d[person][state];
	}
}