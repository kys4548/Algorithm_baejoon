import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        int[][] boxInformations = new int[M][3];
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<3; j++) {
        		boxInformations[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        Arrays.sort(boxInformations, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] temp1, int[] temp2) {
        		if(temp1[0] == temp2[0]) {
        			return temp1[1] - temp2[1];
        		}
        		return temp1[0] - temp2[0];
        	}
        });
        int[] town = new int[N+1];
        int index = 0;
        int currentTruckCapacity = 0;
        for(int i=1; i<=N; i++) {
        	answer += town[i];
        	while(index < M && i == boxInformations[index][0]) {
        		town[boxInformations[index][1]] += boxInformations[index][2];
        		currentTruckCapacity += boxInformations[index][2];
        		index++;
        	}
        	if(currentTruckCapacity > C) {
        		int sum = 0;
        		for(int j =i+1; j<=N; j++) {
        			sum += town[j];
        			if(sum > C) {
        				town[j] -= sum - C;
        				Arrays.fill(town, j+1, N+1, 0);
        				currentTruckCapacity = C;
        				break;
        			}
        		}
        	}
        }
        System.out.println(answer);
        br.close();
    }
}