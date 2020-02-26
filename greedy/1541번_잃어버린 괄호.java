import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().replace("-"," -").replace("+"," +").split(" ");
		
		int index =-1;
		for(int i=1; i<input.length; i++) {
			if(input[i].charAt(0) =='-') {
				index = i;
				break;
			}
		}
		if(index == -1) {
			for(int i=0; i<input.length; i++) {
				answer += Integer.parseInt(input[i]);
			}
		}
        else {
        	for(int i=0; i<index; i++) {
        		answer += Integer.parseInt(input[i]);
        	}
        	for(int i=index; i<input.length; i++) {
        		int n = Integer.parseInt(input[i]);
        		if(n > 0) {
        			answer -= n;
        		}
        		else {
        			answer += n;
        		}
        	}
        }
        System.out.println(answer);
        br.close();
    }
}