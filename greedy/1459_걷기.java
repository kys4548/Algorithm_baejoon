import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        if(2 * w <= s) {
            System.out.println((x+y) * w);
            return;
        }
        
        if(w <= s) {
            if(x <= y) {
                System.out.println(x*s + (y-x)*w);
            } else {
                System.out.println(y*s + (x-y)*w);
            }
            return;
        }
        
        if(x <= y) {
            if((y-x) % 2 == 0) {
                System.out.println(y*s);
            } else {
                System.out.println((y-1)*s + w);
            }
        } else {
            if((x-y) % 2 == 0) {
                System.out.println(x*s);
            } else {
                System.out.println((x-1)*s + w);
            }
        }
    }
}