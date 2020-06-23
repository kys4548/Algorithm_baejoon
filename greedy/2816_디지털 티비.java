import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = "KBS1";
		String str2 = "KBS2";
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		String[] ch = new String[n];
		int idx = -1;
		
		for(int i=0; i<n; i++) {
			ch[i] = br.readLine();
		}
		
		for(int i=0; i<n; i++) {
			if(ch[i].equals(str1)) {
				idx = i;
				break;
			}
		}
		
		for(int i=0; i<idx; i++) {
			String temp = ch[i];
			ch[i] = ch[i+1];
			ch[i+1] = temp;
			sb.append("3");
		}
		if(idx > 1) {
			sb.append("2");
		}
		for(int i=idx-1; i>0; i--) {
			String temp = ch[i];
			ch[i] = ch[i-1];
			ch[i-1] = temp;
			sb.append("4");
		}
		
		for(int i=1; i<n; i++) {
			if(ch[i].equals(str2)) {
				idx = i;
				break;
			}
		}
		
		if(idx >1 && sb.length() != 1) {
			sb.append("1");
		}
		for(int i=1; i<idx; i++) {
			String temp = ch[i];
			ch[i] = ch[i+1];
			ch[i+1] = temp;
			sb.append("3");
		}
		if(idx > 2) {
			sb.append("2");
		}
		for(int i=idx-1; i>1; i--) {
			String temp = ch[i];
			ch[i] = ch[i-1];
			ch[i-1] = temp;
			sb.append("4");
		}
		System.out.println(sb.toString());
	}
}