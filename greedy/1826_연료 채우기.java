import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<int[]>();

        for(int i=0; i<n; i++) {
            int[] temp = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<2; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }
            list.add(temp);
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int depart = Integer.parseInt(st.nextToken());
        pq.add(Integer.parseInt(st.nextToken()));

        int current = 0;
        int answer = -1;
        boolean success = false;

        while(!pq.isEmpty()) {
            if(current >= depart) {
                success = true;
                break;
            }
            current += pq.poll();
            answer++;

            while(!list.isEmpty() &&current >= list.get(0)[0]) {
                int[] temp = list.remove(0);
                pq.add(temp[1]);
            }
        }
        
        if(!success) {
            answer = -1;
        }

        System.out.println(answer);
    }
}