
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str);
		int t = N - str.length() * 9;
		int answer = 0;
		
		for(int i=t; i<N; i++) {
			int sum = i;
			char[] arr = String.valueOf(i).toCharArray();
			
			for(int j=0; j<arr.length; j++) {
				sum += arr[j] - '0';
			}
			if(sum == N) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
}