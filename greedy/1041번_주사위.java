import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        long answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dice = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<6; i++) {
        	dice[i] = Integer.parseInt(st.nextToken());
        }
        if(N == 1) {
        	Arrays.sort(dice);
        	for(int i=0; i<5; i++) {
        		answer += dice[i];
        	}
        	System.out.println(answer);
        	return;
        }
        int[][] twoPick = { {1, 2}, {1, 3}, {4, 2}, {4, 3}, {0, 1}, {0, 4}, 
                            {5, 1}, {5, 4}, {0, 2}, {0, 3}, {5, 2}, {5, 3} 
        };
        int[][] threePick = {
        	{0, 1, 2}, {0, 1, 3}, {0, 4, 2}, {0, 4, 3}, 
        	{5, 1, 2}, {5, 1, 3}, {5, 4, 2}, {5, 4, 3}
        };
        
        int oneMin = 50;
        for(int i=0; i<6; i++) {
        	if(oneMin > dice[i]) {
        		oneMin = dice[i];
        	}
        }
        
        int twoMin = 100;
        for(int i=0; i<12; i++) {
        	int result = 0;
        	for(int j=0; j<2; j++) {
        		result += dice[twoPick[i][j]];
        	}
        	if(twoMin > result) {
        		twoMin = result;
        	}
        }
        
        int threeMin = 150;
        for(int i=0; i<8; i++) {
        	int result = 0;
        	for(int j=0; j<3; j++) {
        		result += dice[threePick[i][j]];
        	}
        	if(threeMin > result) {
        		threeMin = result;
        	}
        }
        
        answer = ( (long)((N-2)) * (N-2) * 5 + (N-2) * 4 ) * oneMin + 
                 ((N-2) * 8 + 4) * twoMin + 
                 4 * threeMin;
        System.out.print(answer);
        br.close();
    }
}