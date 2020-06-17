import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		int[] arr = list.stream().distinct().filter(i -> i <=k).sorted().mapToInt(Integer::valueOf).toArray();
		
		int[] dp = new int[k+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		Arrays.stream(arr).forEach(i -> dp[i] = 1);
		
		for(int i=1; i<k; i++) {
			if(dp[i] == Integer.MAX_VALUE) {
				continue;
			}
			for(int j=0; j<arr.length; j++) {
				if(i+arr[j] > k) {
					break;
				}
				if(dp[i+arr[j]] > dp[i] + 1) {
					dp[i+arr[j]] = dp[i] + 1;
				}
			}
		}
		if(dp[k] == Integer.MAX_VALUE) {
			dp[k] = -1;
		}
		System.out.println(dp[k]);
	}
}