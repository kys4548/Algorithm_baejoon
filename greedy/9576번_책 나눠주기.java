import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
        	int answer = 0;
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	int[][] wantBooksArr = new int[M][2];
        	for(int j=0; j<M; j++) {
        		st = new StringTokenizer(br.readLine());
        		for(int k=0; k<2; k++) {
        			wantBooksArr[j][k] = Integer.parseInt(st.nextToken());
        		}
        	}
        	Arrays.sort(wantBooksArr, new Comparator<int[]>() {
        		@Override
        		public int compare(int[] temp1, int[] temp2) {
        			return temp1[0] - temp2[0];
        		}
        	});
        	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        	int index = 0;
        	for(int j=1; j<=N; j++) {
        		while(!pq.isEmpty()) {
        			if(pq.peek() >= j) {
        				break;
        			}
        			pq.poll();
        		}
        		for(int k=index; k<M; k++) {
        			if(j < wantBooksArr[k][0]) {
        				break;
        			}
        			pq.add(wantBooksArr[k][1]);
        			index++;
        		}
        		if(!pq.isEmpty()) {
        			pq.poll();
        			answer++;
        		}
        	}
        	System.out.println(answer);
        }
        br.close();
    }
}