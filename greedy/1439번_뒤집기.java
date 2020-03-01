import java.io.*;


/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int length = input.length();
		StringBuilder sb = new StringBuilder();
		char c = '-';
		int zeroCount = 0;
		int oneCount = 0;
		for(int i=0; i<length; i++) {
			if(input.charAt(i) != c) {
				c = input.charAt(i);
				if(c == '0') {
					zeroCount++;
				}
				else {
					oneCount++;
				}
			}
		}
		System.out.println(Math.min(oneCount, zeroCount));
	}
}