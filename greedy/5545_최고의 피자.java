import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int toppingNum = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int douCost = Integer.parseInt(st.nextToken());
        int toppingCost = Integer.parseInt(st.nextToken());
        int douCalorie = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i=0; i<toppingNum; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        double totalCost = douCost;
        double totalCalorie = douCalorie;

        while(!pq.isEmpty()) {
            if((totalCalorie / totalCost) < (totalCalorie + pq.peek()) / (totalCost + toppingCost)) {
                totalCost += toppingCost;
                totalCalorie += pq.poll();
            } else {
                break;
            }
        }

        int answer = (int)Math.floor(totalCalorie / totalCost);

        System.out.println(answer);
    }
}