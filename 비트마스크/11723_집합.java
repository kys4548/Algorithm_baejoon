import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

class Main {
	static final String add = "add";
	static final String remove = "remove";
	static final String check = "check";
	static final String toggle = "toggle";
	static final String all = "all";
	static final String empty = "empty";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		final int max = (int)Math.pow(2,21) -1;
		
		int M = Integer.parseInt(br.readLine());
		int answer = 0;
		int x = -1;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
				case add :
					x = Integer.parseInt(st.nextToken());
					answer = answer | (1 << x);
					break;
				case remove :
					x = Integer.parseInt(st.nextToken());
					answer = answer & (max ^ (1 << x));
					break;
				case check :
					x = Integer.parseInt(st.nextToken());
					if((answer & (1 << x)) == (1 << x)) {
						bw.write("1\n");
					} else {
						bw.write("0\n");
					}
					break;
				case toggle :
					x = Integer.parseInt(st.nextToken());
					if((answer & (1 << x)) == (1 << x)) {
						answer = answer & (max ^ (1 << x));
					} else {
						answer = answer | (1 << x);
					}
					break;
				case all :
					answer = max;
					break;
				case empty :
					answer = 0;
					break;
			}
		}
		bw.flush();
	}
}