import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int changes = 1000 - Integer.parseInt(br.readLine());
        int[] arr = {500, 100, 50, 10, 5, 1};
        
        for(int i=0; i<arr.length; i++) {
        	if(changes < arr[i]) {
        		continue;
        	}
        	answer += changes / arr[i];
        	changes %= arr[i];
        	if(changes == 0) {
        		break;
        	}
        }
        System.out.println(answer);
        br.close();
    }
}