import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] crain = new int[n];
		int[] move = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			crain[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] box = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(crain);
		Arrays.sort(box);
		
		int idx=0;
		
		for(int i=0; i<n; i++) {
			while(idx < m && crain[i] >= box[idx]) {
				move[i]++;
				idx++;
			}
		}
		
		if(idx < m) {
			System.out.println(-1);
			return;
		}
		
		int answer = 0;
		boolean finish;
		
		while(m > 0) {
			int predict = (m-1) /n +1;
			for(int i=0; i<n; i++) {
				move[i] -= predict;
			}
			for(int i=n-1; i>0; i--) {
				if(move[i] < 0) {
					move[i-1] += move[i];
					move[i] = 0;
				}
			}
			int sum = 0;
			for(int i=0; i<n; i++) {
				if(move[i] > 0) {
					sum += move[i];
				}
			}
			if(move[0] < 0) {
				move[0] = 0;
			}
			m = sum;
			answer += predict;
		}
		System.out.println(answer);
	}
}