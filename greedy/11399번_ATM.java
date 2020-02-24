import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int index = 0;
        for(String s : br.readLine().split(" ")) {
            arr[index++] = Integer.parseInt(s);
        }
        
        Arrays.sort(arr);
       
        for(int i=0; i<N; i++) {
            answer += arr[i] * (N-i);
            
        }
        System.out.println(answer);
        br.close();
    }
}