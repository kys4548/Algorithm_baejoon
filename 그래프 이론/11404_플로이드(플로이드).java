import java.util.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		final int INF = 20000000;
		final int NIL = -1;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] cost = new int[n][n];
		int[][] path = new int[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(cost[i], INF);
			Arrays.fill(path[i], NIL);
			cost[i][i] = 0;
		}
		
		for(int i=0; i<m; i++) {
			st= new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int value = Integer.parseInt(st.nextToken());
			
			if(cost[start][end] > value) {
				cost[start][end] = value;
				path[start][end] = start;
			}
		}
		solve(cost, path, n, INF);
		print(cost, n);
		//print(path, n);
	}
	
	public static void solve(int[][] cost, int[][] path, int n, int INF) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					if(cost[j][k] > cost[j][i] + cost[i][k]) {
						cost[j][k] = cost[j][i] + cost[i][k];
						path[j][k] = i;
					}
				}
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(cost[i][j] == INF) {
					cost[i][j] = 0;
				}
			}
		}
	}
	
	public static void print(int[][] array, int n) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}