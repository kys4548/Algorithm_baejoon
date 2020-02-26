import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        // 최장 증가 수열
        int[] tailTable = new int[n];
        int lisLength = 0;
        
        tailTable[0] = arr[0];
        lisLength = 1;
        
        for(int i=1; i<n; i++) {
        	if(arr[i] < tailTable[0]) {
        		tailTable[0] = arr[i];
        	}
        	else if(arr[i] > tailTable[lisLength-1]) {
        		tailTable[lisLength] = arr[i];
        		lisLength++;
        	}
        	else {
        		int idx = Arrays.binarySearch(tailTable, 0, lisLength, arr[i]);
        		idx = idx < 0 ? -idx -1 : idx;
        		tailTable[idx] = arr[i];
        	}
        }
        System.out.println(lisLength);
        br.close();
    }
}