import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] front = new int[n];
		int[] back = new int[n];
		for(int i=0; i<n; i++) {
			front[i] = Integer.parseInt(st.nextToken());
			back[n-1-i] = front[i];
		}
		
		List<Integer> fList = new ArrayList<Integer>();
		List<Integer> bList = new ArrayList<Integer>();
		int fMax = 0;
		int bMax = 0;
		int[] fDp = new int[n];
		int[] bDp = new int[n];
		int a;
		
		for(int i=0; i<n; i++) {
			a = Collections.binarySearch(fList, front[i]);
			if(a < 0) {
				a = -a -1;
				if(a == fMax) {
					fList.add(a, front[i]);
					fMax++;
				} else {
					fList.set(a, front[i]);
				}
			}
			fDp[i] = fList.size();
			
			a = Collections.binarySearch(bList, back[i]);
			if(a < 0) {
				a = -a -1;
				if(a == bMax) {
					bList.add(a, back[i]);
					bMax++;
				} else {
					bList.set(a, back[i]);
				}
			}
			bDp[i] = bList.size();
		}
		
		int answer = 0;
		for(int i=0; i<n; i++) {
			if(answer < fDp[i] + bDp[n-1 -i]) {
				answer = fDp[i] + bDp[n-1 -i];
			}
		}
		System.out.println(answer-1);
	}
}