import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Integer> plusList = new ArrayList<Integer>();
		List<Integer> minusList = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num < 0) {
				minusList.add(num);
			} else if(num > 0){
				plusList.add(num);
			}
		}
		Collections.sort(minusList);
		Collections.sort(plusList, Collections.reverseOrder());
		int answer = 0;
		int max = -1;
		
		if(minusList.isEmpty()) {
			max = plusList.get(0);
		} else if(plusList.isEmpty()) {
			max = -minusList.get(0);
		} else {
			max = Math.max(-minusList.get(0), plusList.get(0));
		}
		
		while(!minusList.isEmpty()) {
			answer -= (2*minusList.get(0));
			for(int i=0; i<m; i++) {
				if(minusList.isEmpty()) {
					break;	
				}
				minusList.remove(0);
			}
		}
		
		while(!plusList.isEmpty()) {
			answer += (2*plusList.get(0));
			for(int i=0; i<m; i++) {
				if(plusList.isEmpty()) {
					break;	
				}
				plusList.remove(0);
			}
		}
		
		answer -= max;
		System.out.println(answer);
		
	}
}