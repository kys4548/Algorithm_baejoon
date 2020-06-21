import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();
		int length = input.length();
		
		int count = 0;
		
		for(int i=0; i<length; i++) {
			if(input.charAt(i) == '.') {
				if(count == 0) {
					sb.append('.');
					continue;
				}
				while(count > 4) {
					sb.append("AAAA");
					count -=4;
				}
				
				if(count == 2) {
					sb.append("BB");
				} else if(count == 4) {
					sb.append("AAAA");
				} else {
					System.out.println(-1);
					return;
				}
				sb.append('.');
				count = 0;
			} else {
				count++;
			}
		}
		while(count > 4) {
			count -=4;
			sb.append("AAAA");
		}
		if(count == 2) {
			sb.append("BB");
		} else if(count == 4) {
			sb.append("AAAA");
		} else if(count == 0){
			
		} else {
			System.out.println(-1);
			return;
		}
		System.out.println(sb.toString());
	}
}