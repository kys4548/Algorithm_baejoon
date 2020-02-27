import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		String[] multitap = new String[N];
		List<String> order = new ArrayList<String>(Arrays.asList(br.readLine().split(" ")));
		Set<String> set = new HashSet<String>();
		
		int tapIndex = 0;
		for(int i=0; i<K; i++) {
			if(set.contains(order.get(0))) {
				order.remove(0);
			}
			else {
				set.add(order.get(0));
				multitap[tapIndex++] = order.remove(0);
			}
			
			if(tapIndex == N) {
				break;
			}
		}
		if(order.isEmpty()) {
			System.out.println(answer);
		}
		K = order.size();
		for(int i=0; i<K; i++) {
			if(set.contains(order.get(0))) {
				order.remove(0);
				continue;
			}
			
			int index = -1;
			int max = 0;
			for(int j=0; j<N; j++) {
				int nextProduct = order.indexOf(multitap[j]);
				if(nextProduct == -1) {
					index = j;
					break;
				}
				if(nextProduct > max) {
					index = j;
					max = nextProduct;
				}
			}
			set.remove(multitap[index]);
			set.add(order.get(0));
			multitap[index] = order.remove(0);
			answer++;
		}
        System.out.println(answer);
        br.close();
    }
}