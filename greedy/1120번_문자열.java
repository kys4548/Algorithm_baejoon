import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        int answer = 50;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int Xlength = input[0].length();
		int Ylength = input[1].length();
        
        for(int i=0; i<=Ylength- Xlength; i++) {
        	int count = 0;
        	for(int j=0; j<Xlength; j++) {
        		if(input[0].charAt(j) != input[1].charAt(i+j)) {
        			count++;
        		}
        	}
        	if(answer > count) {
        		answer = count;
        	}
        }
        System.out.println(answer);
        br.close();
    }
}