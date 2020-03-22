import java.io.BufferedReader;
import java.io.InputStreamReader;
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N <100) {
			System.out.println(N);
			return;
		}
		int answer = 99;
		for(int i=111; i<=N; i++) {
			String str = String.valueOf(i);
			if(str.charAt(0) - str.charAt(1) == str.charAt(1) - str.charAt(2)) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}