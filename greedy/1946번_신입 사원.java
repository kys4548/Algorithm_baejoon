import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
        	int N = Integer.parseInt(br.readLine());
        	int answer = 0;
        	int[][] scores = new int[N][2];
        	for(int j=0; j<N; j++) {
        		scores[j] =  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        	}
        	Arrays.sort(scores, new Comparator<int[]>() {
        		@Override
        		public int compare(int[] temp1, int[] temp2) {
        			return temp1[0] - temp2[0];
        		}
        	});
        	int rank = scores[0][1];
        	answer++;
        	for(int j=1; j<N; j++) {
        		if(scores[j][1] > rank) {
        			continue;
        		}
        		rank = scores[j][1];
        		answer++;
        	}
        	System.out.println(answer);
        }
        br.close();
    }
}