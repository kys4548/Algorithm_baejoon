import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] subjects = new ArrayList[n];
        List<Integer> result = new ArrayList<Integer>();

        int answer = 0;

        for(int i=0; i<n; i++) {
            subjects[i] = new ArrayList<Integer>();
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            if(l > p) {
                if(m > 0) {
                    m--;
                    answer++;
                }
                br.readLine();
                continue;
            }
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<p; j++) {
                subjects[i].add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(subjects[i]);

            for(int j=0; j<l-1; j++) {
                subjects[i].remove(subjects[i].size()-1);
            }

            result.add(subjects[i].get(subjects[i].size()-1));
        }

        Collections.sort(result);

        while(!result.isEmpty()) {
            if(m - result.get(0) >= 0) {
                m -= result.remove(0);
                answer++;
            } else {
                break;
            }
        }

        System.out.println(answer);
    }
}