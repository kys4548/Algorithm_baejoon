import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Collections;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			
			List<Integer> list = new LinkedList<Integer>();
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				list.add(Integer.parseInt(st.nextToken()));
				pq.add(list.get(j));
			}
			int count = 0;
			
			while(true) {
				
				while(list.get(0) != pq.peek()) {
					list.add(list.remove(0));
					index--;
					if(index < 0) {
						index += list.size();
					}
				}
				if(index == 0) {
					break;
				}
				pq.poll();
				list.remove(0);
				index--;
				count++;
			}
			System.out.println(count+1);
		}
	}
}