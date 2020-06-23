import java.io.*;
import java.util.*;
 
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		StringTokenizer st;
		Problem[] arr = new Problem[n];
		
		int answer = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int deadLine = Integer.parseInt(st.nextToken());
			int ramenNum = Integer.parseInt(st.nextToken());
			arr[i] = new Problem(deadLine, ramenNum);
		}
		
		Arrays.sort(arr);
		int idx = 0;
		int time = arr[0].deadLine;
		
		for(int i=time; i>0; i--) {
			while(idx <n && arr[idx].deadLine >= i) {
				pq.add(arr[idx].ramenNum);
				idx++;
			}
			
			if(!pq.isEmpty()) {
				answer += pq.poll();
			}
		}
		
		System.out.println(answer);
	}
}

class Problem implements Comparable<Problem> {
	int deadLine;
	int ramenNum;
	
	Problem(int deadLine, int ramenNum) {
		this.deadLine = deadLine;
		this.ramenNum = ramenNum;
	}
	
	@Override
	public int compareTo(Problem p) {
		return p.deadLine - this.deadLine;
	}
}