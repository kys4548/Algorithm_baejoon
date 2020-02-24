import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        String answer = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		//10의 배수 판별
		if(!input.contains("0")) {
			System.out.println("-1");
			return;
		}
		char[] arr = input.replace(" ","").toCharArray();
		int N = 0;
		//3의 배수 판별
		for(int i=0; i<arr.length; i++) {
			N += arr[i] - '0';
		}
		if(N % 3 != 0) {
			System.out.println("-1");
			return;
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i=arr.length-1; i>=0; i--) {
			sb.append(arr[i]);
		}
        answer = sb.toString();
        System.out.println(answer);
        br.close();
    }
}