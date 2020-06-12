import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		int maps[][] = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			maps[v1][v2] = 1;
			maps[v2][v1] = 1;
		}
		
		boolean visited[] = new boolean[N+1];
		List<Integer> list = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		list.add(start);
		
		dfs(maps, N, visited, list, sb);
		
		Arrays.fill(visited, false);
		list.clear();
		sb.setLength(0);
		list.add(start);
		visited[start] = true;
		
		bfs(maps, N, visited, list, sb);
	}
	
	public static void bfs(int maps[][], int N, boolean[] visited, List<Integer> list, StringBuilder sb) {
		//base case
		if(list.isEmpty()) {
			System.out.println(sb.toString());
			return;
		}
		
		//전처리
		int v = list.remove(0);
		sb.append(v + " ");
		
		for(int i=1; i<=N; i++) {
			if(maps[v][i] == 1 && visited[i] == false) {
				list.add(i);
				visited[i] = true;
			}
		}
		
		//재귀
		bfs(maps, N, visited, list, sb);
	}
	
	public static void dfs(int maps[][], int N, boolean[] visited, List<Integer> list, StringBuilder sb) {
		//base case
		while(list.size() != 0 && visited[list.get(list.size()-1)] == true) {
			list.remove(list.size() -1);
		}
		if(list.isEmpty()) {
			System.out.println(sb.toString());
			return;
		}
		
		//전처리
		int v = list.remove(list.size()-1);
		visited[v] = true;
		sb.append(v + " ");
		
		for(int i=N; i>=1; i--) {
			if(maps[v][i] == 1 && visited[i] == false) {
				list.add(i);
			}
		}
		
		dfs(maps, N, visited, list, sb);
	}
}