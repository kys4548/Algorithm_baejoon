import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][2];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] t1, int[] t2) {
				return t1[0] - t2[0];
			}
		});
		
		int answer = 0;
		int current = -1;

		for(int i=0; i<n; i++) {
			if(current >=arr[i][1]) {
				continue;
			}
			if(arr[i][0] > current) {
				current = arr[i][0];
			}
			int dis = arr[i][1] - current;
			int count = dis / m;
			
			current += count * m;
			
			if(current < arr[i][1]) {
				count++;
				current += m;
			}
			answer += count;
		}
		
		System.out.println(answer);
	}
}