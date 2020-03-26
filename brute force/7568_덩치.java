import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] people = new int[N][2];
		int[] answer = new int[N];
		
		for(int i=0; i<N; i++) {
			int[] temp = new int[2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
				temp[j] = Integer.parseInt(st.nextToken());
			}
			people[i] = temp;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if(people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
					answer[i]++;
				}
				else if(people[i][0] > people[j][0] && people[i][1] > people[j][1]) {
					answer[j]++;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			answer[i]++;
			System.out.print(answer[i] + " ");
		}
	}
}