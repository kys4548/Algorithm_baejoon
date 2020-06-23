import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		long answer = 0;
		int rank = 1;
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		for(int i=0; i<n; i++) {
			answer += Math.abs(rank - arr[i]);
			rank++;
		}
		
		System.out.println(answer);
	}
}