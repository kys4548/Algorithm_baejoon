import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int roomA = Integer.parseInt(st.nextToken());
			int roomB = Integer.parseInt(st.nextToken());
			if(n == 0 && roomA == 0 && roomB == 0) {
				break;
			}
			
			Team[] arr = new Team[n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int count = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[i] = new Team(count, a, b);
			}
			Arrays.sort(arr);
			
			int answer = 0;
			
			for(int i=0; i<n; i++) {
				if(roomA == 0) {
					answer += arr[i].b * arr[i].count;
					continue;
				}
				if(roomB == 0) {
					answer += arr[i].a * arr[i].count;
					continue;
				}
				if(arr[i].a <= arr[i].b) {
					if(roomA >= arr[i].count) {
						answer += arr[i].a * arr[i].count;
						roomA -= arr[i].count;
						arr[i].count = 0;
					} else {
						answer += arr[i].a * roomA;
						arr[i].count -= roomA;
						roomA = 0;
					}
				} else {
					if(roomB >= arr[i].count) {
						answer += arr[i].b * arr[i].count;
						roomB -= arr[i].count;
						arr[i].count = 0;
					} else {
						answer += arr[i].b * roomB;
						arr[i].count -= roomB;
						roomB = 0;
					}
				}
				
				
				if(arr[i].count != 0) {
					if(roomA == 0) {
						answer += arr[i].count * arr[i].b;
					} else {
						answer += arr[i].count * arr[i].a;
					}
				}
				
				
			}
			System.out.println(answer);
		}
	}
}


class Team implements Comparable<Team> {
	int count;
	int a;
	int b;
	
	Team(int count, int a, int b) {
		this.count = count;
		this.a = a;
		this.b = b;
	}
	
	@Override
	public int compareTo(Team t) {
		return Math.abs(t.a-t.b) - Math.abs(this.a-this.b);
	}
}