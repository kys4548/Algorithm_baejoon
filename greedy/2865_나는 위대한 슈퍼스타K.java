import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.time.Period;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<Integer>();
        List<Person>[] genre = new List[m];

        for(int i=0; i<m; i++) {
            genre[i] = new ArrayList<Person>();
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int id = Integer.parseInt(st.nextToken());
                double score = Double.parseDouble(st.nextToken());
                genre[i].add(new Person(id, score));
            }
        }

        double answer = 0;
        for(int i=0; i<k; i++) {
            for(int j=0; j<m; j++) {
                while(set.contains(genre[j].get(0).id)) {
                    genre[j].remove(0);
                }
            }

            int idx = -1;
            double max = -1;

            for(int j=0; j<m; j++) {
                if(genre[j].get(0).score > max) {
                    idx = j;
                    max = genre[j].get(0).score;
                }
            }

            answer += max;
            set.add(genre[idx].get(0).id);
        }

        System.out.printf("%.1f", answer);
    }
}


class Person {
    int id;
    double score;

    Person(int id, double score) {
        this.id = id;
        this.score = score;
    }
}