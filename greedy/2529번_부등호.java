import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.HashSet;
public class Main {
    public static void main(String []args) throws Exception { //예외처리 필수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		char[] answer = new char[k+1];
		boolean[] visited = new boolean[k+1];
		Set<Character> set = new HashSet<Character>();
		char c = ' ';
		for(int i=0; i<k; i++) {
			if(arr[i].equals(">")) {
				c = '9';
				while(set.contains(c)) {
					c--;
				}
				for(int j=i; j>=0; j--) {
					if(visited[j] == false) {
						answer[j] = c;
						set.add(c--);
						visited[j] = true;
					}
					else {
						break;
					}
				}
			}
		}
		c = '9';
		while(set.contains(c)) {
			c--;
		}
		int index = k;
		while(index >= 0 && visited[index] == false) {
			answer[index] = c;
			index--;
			c--;
		}
		System.out.println(String.valueOf(answer));
		
		
		
		answer = new char[k+1];
		visited = new boolean[k+1];
		set.clear();
		for(int i=0; i<k; i++) {
			if(arr[i].equals("<")) {
				c = '0';
				while(set.contains(c)) {
					c++;
				}
				for(int j=i; j>=0; j--) {
					if(visited[j] == false) {
						answer[j] = c;
						set.add(c++);
						visited[j] = true;
					}
					else {
						break;
					}
				}
			}
		}
		c = '0';
		while(set.contains(c)) {
			c++;
		}
		index = k;
		while(index >= 0 && visited[index] == false) {
			answer[index] = c;
			index--;
			c++;
		}
		System.out.println(String.valueOf(answer));
		
		
		
        br.close();
    }
}