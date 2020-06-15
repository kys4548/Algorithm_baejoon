import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] maps = new int[n][n];
		final int MAX = 100000000;
		
		for(int i=0; i<n; i++) {
			Arrays.fill(maps[i], MAX);
		}
		StringTokenizer st;
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			
			if(maps[start][end] > cost) {
				maps[start][end] = cost;
			}
		}
		
		for(int i=0; i<n; i++) {
			
			int v = i;
			Set<Integer> set = new HashSet<Integer>();
			set.add(v);
			while(true) {
				int min = MAX;
				for(int j=0; j<n; j++) {
					if(set.contains(j)) {
						continue;
					}
					if(maps[i][j] < min) {
						min = maps[i][j];
						v = j;
					}
				}
				if(set.contains(v)) {
					break;
				}
				set.add(v);
				
				for(int j=0; j<n; j++) {
					if(set.contains(j)) {
						continue;
					}
					if(maps[i][j] > maps[i][v] + maps[v][j]) {
						maps[i][j] = maps[i][v] + maps[v][j];
					}
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(maps[i][j] >= MAX) {
					maps[i][j] = 0;
				}
				System.out.print(maps[i][j] + " ");
			}
			System.out.println();
		}
	}
}