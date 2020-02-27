import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		String[] DNA = new String[N];
		int[][] count = new int[M][26];
		for(int i=0; i<N; i++) {
			DNA[i] = br.readLine();
		}
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				count[i][DNA[j].charAt(i) -'A']++;
			}
		}
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
        	int max = -1;
        	int index = -1;
        	for(int j=0; j<26; j++) {
        		if(max < count[i][j]) {
        			max = count[i][j];
        			index = j;
        		}
        	}
        	answer += N - max;
        	sb.append((char)('A'+index));
        }
        System.out.println(sb.toString());
        System.out.println(answer);
        br.close();
    }
}