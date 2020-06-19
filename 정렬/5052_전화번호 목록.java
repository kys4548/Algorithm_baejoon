import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final String yes = "YES";
		final String no = "NO";
		
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			
			int n = Integer.parseInt(br.readLine());
			String[] arr = new String[n];
			for(int j=0; j<n; j++) {
				arr[j] = br.readLine();
			}
			Arrays.sort(arr);
			boolean possible = true;
			for(int j=1; j<n; j++) {
				if(arr[j].startsWith(arr[j-1])) {
					possible = false;
					break;
				}
			}
			if(possible == true) {
				System.out.println(yes);
			} else {
				System.out.println(no);
			}
		}
	}
}