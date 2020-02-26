import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> set = new HashSet<Integer>();
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] answer = new int[N];
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(input[i]);
			int differ = N-1 -i - num;
			int index = N-1;
			for(int j=N-1; j>=0; j--) {
				if(answer[j] != 0) {
					index--;
				}
				else {
					break;
				}
			}
			while(differ > 0) {
				index--;
				if(answer[index] != 0) {
					continue;
				}
				differ--;
			}
			answer[index] = i+1;
		}
		for(int i=0; i<N; i++) {
			System.out.print(answer[i]+ " ");
		}
        br.close();
    }
}