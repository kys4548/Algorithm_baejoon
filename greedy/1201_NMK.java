import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		//예외 케이스1
		if(n+1 < m + k) {
			System.out.println(-1);
			return;
		}
		
		//예외 케이스2
		if((n/m + (n%m & 1) > k) || (n/k + (n%k & 1)) > m) {
			System.out.println(-1);
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(n - m >= k-1) {
			if(n == 1 && m == 1 & k == 1) {
				sb.append(k--);
				break;
			}
			for(int i=n -m +1; i<=n; i++) {
				sb.append(i).append(" ");
			}
			n -=m;
			k--;
		}
		
		if(k == 0) {
			System.out.println(sb.toString());
			return;
		}
		
		int quo = n/k;
		int rest = n%k;
		
		for(int i=0; i<k; i++) {
			int count = quo;
			if(rest > 0) {
				count++;
				rest--;
			}
			for(int j=n-count+1; j<=n; j++) {
				sb.append(j).append(" ");
			}
			n -= count;
		}
		System.out.println(sb.toString());
	}
}