import java.io.*;
import java.util.*;


class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<n; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);
		
		List<Integer> list2 = new ArrayList<Integer>();
		
		for(int i=0; i<list.size()-1; i++) {
			list2.add(list.get(i+1) - list.get(i));
		}
		Collections.sort(list2);
		int answer = 0;
		
		for(int i=0; i<list2.size()-k+1; i++) {
			answer += list2.get(i);
		}
		System.out.println(answer);
	}
}