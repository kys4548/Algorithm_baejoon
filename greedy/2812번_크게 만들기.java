import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append(input.charAt(0));
        int len = 1;
        for(int i=1; i<N; i++) {
        	if(K == 0) {
        		sb.append(input.substring(i));
        		break;
        	}
        	int min = Math.max(0, len - K);
        	boolean isFind = false;
        	for(int j=min; j<len; j++) {
        		if(sb.charAt(j) < input.charAt(i)) {
        			sb.setLength(j);
        			K -= len -j;
        			sb.append(input.charAt(i));
        			len = j+1;
        			isFind = true;
        			break;
        		}
        	}
        	if(isFind == false) {
        		if(len < N-K) {
        			sb.append(input.charAt(i));
        			len++;
        		}
        	}
        }
        System.out.println(sb.toString());
        br.close();
    }
}