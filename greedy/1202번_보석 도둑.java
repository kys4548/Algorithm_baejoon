import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        long answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] jewelArr = new int[N][2];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<2; j++) {
        		jewelArr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        int[] bags = new int[K];
        for(int i=0; i<K; i++) {
        	bags[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(jewelArr, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] temp1, int[] temp2) {
        		return temp1[0] - temp2[0];
        	}
        });
        Arrays.sort(bags);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        int index = 0;
        for(int i=0; i<K; i++) {
        	for(int j=index; j<N; j++) {
        		if(bags[i] < jewelArr[j][0]) {
        			break;
        		}
        		pq.add(jewelArr[j][1]);
        		index++;

        	}
        	if(!pq.isEmpty()) {
        		answer += pq.poll();
        	}
        }
        System.out.println(answer);
        br.close();
    }
}