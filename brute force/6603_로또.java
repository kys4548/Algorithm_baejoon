import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if(N == 0) {
				return;
			}
			
			int[] lotto = new int[N];
			for(int i=0; i<N; i++) {
				lotto[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(lotto);
			int[] number = new int[6];
			combination(0, 6, 0, N, lotto, number);
			System.out.println();
		}

	}

	public static void combination(int count, int max, int cursor, int N, int[] lotto, int[] number) {
		if(count == max) {
			for(int i=0; i<max; i++) {
				System.out.print(number[i]+" ");
			}
			System.out.println();
			return;
		}
		
		if(cursor >= N) {
			return;
		}
		
		number[count] = lotto[cursor];
		combination(count+1, max, cursor+1, N, lotto, number);
		combination(count, max, cursor+1, N, lotto, number);
	}

}