import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		int[] arr = new int[n];
		int max = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=n-1; i>=0; i--) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int num : arr) {
			int idx = Collections.binarySearch(list, num);
			if(idx < 0) {
				idx = -idx -1;
				if(max == idx) {
					list.add(idx,num);
					max++;
				} else {
					list.set(idx,num);	
				}
			} 
		}
		System.out.println(list.size());
	}
}