import java.io.*;


/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int answer = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int M = Integer.parseInt(input[1]);
		int start = 1;
		int end = M;
		int count = Integer.parseInt(br.readLine());
		for(int i=0; i<count; i++) {
			int position = Integer.parseInt(br.readLine());
			if(start > position) {
				answer += start - position;
				start = position;
				end = start + M -1;
			}
			else if(end < position) {
				answer += position - end;
				end = position;
				start = end - M +1;
			}
		}
		System.out.println(answer);
	}
}