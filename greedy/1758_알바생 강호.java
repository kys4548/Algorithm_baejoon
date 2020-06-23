import java.io.*;
import java.util.*;
 
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		long answer = 0;
 
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int order = 0;
 
		for(int i=n-1; i>=0; i--) {
			int tip = arr[i] -order;
			if(tip > 0) {
				answer += tip;
			}
			order++;
		}
 
		System.out.println(answer);
	}
}