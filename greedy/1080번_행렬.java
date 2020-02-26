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
        int[][] arr1 = new int[N][M];
        for(int i=0; i<N; i++) {
        	char[] temp = br.readLine().toCharArray();
        	for(int j=0; j<M; j++) {
        		arr1[i][j] = temp[j] - '0';
        	}
        }
        int[][] arr2 = new int[N][M];
        for(int i=0; i<N; i++) {
        	char[] temp = br.readLine().toCharArray();
        	for(int j=0; j<M; j++) {
        		arr2[i][j] = temp[j] - '0';
        	}
        }
        
        for(int i=0; i<=N-3; i++) {
        	for(int j=0; j<= M-3; j++) {
        		if(arr1[i][j] == arr2[i][j]) {
        			continue;
        		}
        		answer++;
        		for(int k=0; k<3; k++) {
        			for(int l=0; l<3; l++) {
        				if(arr1[i+k][j+l] == 0) {
        					arr1[i+k][j+l]++;
        				}
        				else {
        					arr1[i+k][j+l]--;
        				}
        			}
        		}
        	}
        }
        boolean isEquals = true;
        for(int i=0; i<N; i++) {
        	if(Arrays.equals(arr1[i],arr2[i]) == false) {
        		isEquals = false;
        		break;
        	}
        }
        if(isEquals == false) {
        	answer = -1;
        }
        System.out.println(answer);
        br.close();
    }
}