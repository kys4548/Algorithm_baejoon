import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        //n은 보석 갯수, k는 가방 갯수
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        //보석 무게순으로 정렬
        List<Jewelry> jewelryList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            Jewelry jewelry = new Jewelry(weight, price);
            jewelryList.add(jewelry);
        }
        Collections.sort(jewelryList);


        //가방 무게순으로 정렬
        int[] bagMaxWeight = new int[k];
        for(int i=0; i<k; i++) {
            bagMaxWeight[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bagMaxWeight);

        //가방 무게를 초과하지 않는 보석들의 price를 pq에 모두 넣고 하나씩 꺼내 가방에 집어넣는다.
        //pq는 항상 값어치 비싼 보석이 먼저 나온다.
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((p1, p2) -> p2 - p1);
        int index =0 ;
        for(int i=0; i<bagMaxWeight.length; i++) {
            while(index < jewelryList.size() && jewelryList.get(index).weight <= bagMaxWeight[i]) {
                pq.add(jewelryList.get(index).price);
                index++;
            }
            if(!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        System.out.println(answer);
    }
}

class Jewelry implements Comparable<Jewelry> {
    int weight;
    int price;

    public Jewelry(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int compareTo(Jewelry jewelry) {
        return this.weight - jewelry.weight;
    }
}