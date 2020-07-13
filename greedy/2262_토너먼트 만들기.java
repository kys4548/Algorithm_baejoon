import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;

        while(list.size() > 1) {

            int idx = -1;
            int rank = -1;
            int result = -1;

            for(int j=0; j<list.size(); j++) {
                if(rank < list.get(j)) {
                    rank = list.get(j);
                    idx = j;
                }
            }
            if(idx == 0) {
                answer += rank - list.get(idx+1);
            } else if(idx == list.size() -1) {
                answer += rank - list.get(idx-1);
            } else {
                answer += Math.min(rank - list.get(idx-1), rank - list.get(idx+1));
            }
            list.remove(idx);
        }
        System.out.println(answer);
    }
}