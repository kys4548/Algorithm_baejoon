import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        if(N == 1) {
        	answer = 1;
        }
        else if(N == 2) {
        	if(M <= 6) {
        		answer = (M+1) /2;
        	}
        	else {
        		answer = 4;
        	}
        }
        else { // N이 3이상일 때
        	if(M <= 3) {
        		answer = M;
        	}
        	else if(M <= 6) {
        		answer = 4;
        	}
        	else {
        		answer = M-2;
        	}
        }
        
        System.out.println(answer);
        br.close();
    }
}