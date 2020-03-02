import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		boolean[][] maps = new boolean[R][C];
		for(int i=0; i<R; i++) {
			String input = br.readLine();
			for(int j=0; j<C; j++) {
				if(input.charAt(j) == '.') {
					maps[i][j] = true;
				}
			}
		}
		boolean[][] visited = new boolean[R][C];
        for(int i=0; i<R; i++) {
        	if(isPossiblePipe(maps, i, 0, R, C, visited)) {
        		answer++;
        	}
        }
        System.out.println(answer);
        br.close();
    }
    public static boolean isPossiblePipe(boolean[][] maps, int row, int col, int R, int C, boolean[][] visited) {
    	if(row <0 || row >= R || col < 0 || col >= C || visited[row][col] == true || maps[row][col] == false) {
    		return false;
    	}
    	if(col == C-1) {
    		visited[row][col] = true;
    		if(maps[row][col] == true) {
    			maps[row][col] = false;
    			return true;
    		}
    		return false;
    	}
    	
    	boolean result = false;
    	if(isPossiblePipe(maps, row-1, col+1, R, C, visited) == true) {
    		result = true;
    	}
    	else if(isPossiblePipe(maps, row, col+1, R, C, visited) == true) {
    		result = true;
    	}
    	else if(isPossiblePipe(maps, row+1, col+1, R, C, visited) == true) {
    		result = true;
    	}
    	
    	if(result == true) {
    		maps[row][col] = false;
    	}
    	visited[row][col] = true;
    	return result;
    }
}