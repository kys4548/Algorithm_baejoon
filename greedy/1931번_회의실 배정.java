import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for(int i=0; i<N; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] temp1, int[] temp2) {
				if(temp1[1] == temp2[1]) {
					return temp1[0] - temp1[1];
				}
				return temp1[1] - temp2[1];
			}
		});
		int time = 0;
		for(int i=0; i<N; i++) {
			if(arr[i][0] >= time) {
				time = arr[i][1];
				answer++;
			}
		}
		System.out.print(answer);
		
		br.close();
	}
}