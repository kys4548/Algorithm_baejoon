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
        int n = Integer.parseInt(br.readLine());
        Employee[] arr = new Employee[n];
        for(int i=0; i<n; i++) {
            arr[i] = new Employee();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();

        for(int i=1; i<n; i++) {
            arr[Integer.parseInt(st.nextToken())].list.add(arr[i]);
        }

        int answer = dp(arr[0]);
        System.out.println(answer);
    }

    private static int dp(Employee employee) {
        if(employee.list.isEmpty()) {
            return 0;
        }

        int time = employee.list.size();

        List<Integer> tempList = new ArrayList<Integer>();
        for(Employee temp : employee.list) {
            tempList.add(dp(temp));
        }
        Collections.sort(tempList, Collections.reverseOrder());

        int addTime = 0;
        for(int i=0; i<employee.list.size(); i++) {
            if(addTime < tempList.get(i) - (time-i -1)) {
                addTime = tempList.get(i) - (time-i -1);
            }
        }

        return time + addTime;
    }
}

class Employee {
    List<Employee> list;

    Employee() {
        list = new ArrayList<Employee>();
    }
}