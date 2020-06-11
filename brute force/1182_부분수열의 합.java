import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

class Main {
	
	static int answer = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			com(arr, N, 0, i, 0, 0, S);
		}
		
		System.out.println(answer);
	}
	
	public static void com(int[] arr, int N, int cursor, int K, int count, int sum, int S) {
		if(count == K) {
			if(sum == S) {
				answer++;
			}
			return;
		}
		
		if(cursor == N) {
			return;
		}
		
		com(arr, N, cursor+1, K, count+1, sum+arr[cursor], S);
		com(arr, N, cursor+1, K, count, sum, S);
	}
}