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
        int[][] costs = new int[M][2];
        int minSetCost = 1000;
        int minOneCost = 1000;
        for(int i=0; i<M; i++) {
        	costs[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        	minSetCost = Math.min(minSetCost, Math.min(costs[i][0], costs[i][1] * 6));
        	minOneCost = Math.min(minOneCost, costs[i][1]);
        }
        if(minSetCost == 0 || minOneCost == 0) {
        	System.out.println(answer);
        	return;
        }
        
        if(N >= 6) {
        	answer = ( N / 6 ) * minSetCost;
        	N %= 6;
        }
        if(N != 0) {
        	answer += Math.min(minSetCost, minOneCost * N);
        }
        
        System.out.println(answer);
        br.close();
    }
}