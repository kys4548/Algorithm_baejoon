import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String document = br.readLine();
		String word = br.readLine();
		int documentLen = document.length();
		int wordLen = word.length();
		for(int i = 0 ; i<=documentLen - wordLen; i++) {
			if(document.startsWith(word,i) == true) {
				i += wordLen-1;
				answer++;
			}
		}
        
        System.out.println(answer);
        br.close();
    }
}