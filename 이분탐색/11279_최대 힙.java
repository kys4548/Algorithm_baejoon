import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinHeap minHeap = new MinHeap();
        int n  = Integer.parseInt(br.readLine());
 
        for(int i=0; i<n; i++) {
            int data = Integer.parseInt(br.readLine());
            if(data == 0) {
                System.out.println(minHeap.delete());
            } else {
                minHeap.insert(data);
            }
        }
    }
}
 
class MinHeap {
 
    private List<Integer> heap;
 
    public MinHeap() {
        heap = new ArrayList<>();
    }
 
    public void insert(int data) {
        heap.add(data);
        int index = heap.size() -1;
 
        // leaf -> root
        while(index > 0) {
            int parentIndex = (index-1) / 2;
            int parent = heap.get(parentIndex);
            int child = heap.get(index);
 
            //자식이 부모보다 작거나 같다면 종료
            if(child <= parent) {
                break;
            }
 
            //자식이 부모보다 크면 위치를 바꾼다.
            heap.set(parentIndex, child);
            heap.set(index, parent);
            index = parentIndex;
        }
    }
 
    public int delete() {
        //힙이 비어있다면 Exception 발생
        if(heap.isEmpty()) {
            return 0;
        }
 
        //힙에 데이터가 1개 일 때
        if(heap.size() == 1) {
            return heap.remove(0);
        }
 
        //힙에 데이터가 2개 이상일 때
        //가장 마지막 값을 root로 덮어씌우고 가장 마지막 노드를 지운다.
        int result = heap.get(0);
        int data = heap.remove(heap.size() -1);
        heap.set(0, data);
 
        //insert method 반대방향으로 진행 root -> leaf
        int index = 0;
        int lastIndex = heap.size() -1;
        int childIndex = (index+1) * 2 - 1;
 
        while(childIndex <= lastIndex) {
            int parent = heap.get(index);
            boolean isChanged = false;
            if(childIndex == lastIndex && heap.get(childIndex) > parent) {
                isChanged = true;
                heap.set(index, heap.get(childIndex));
                heap.set(childIndex, parent);
            } else if(childIndex < lastIndex) {
                int child = heap.get(childIndex);
                if(child < heap.get(childIndex+1)) {
                    child = heap.get(childIndex+1);
                    childIndex += 1;
                }
                if(parent < child) {
                    isChanged = true;
                    heap.set(index, child);
                    heap.set(childIndex, parent);
                    index = childIndex;
                    childIndex = (index+1) * 2 -1;
                }
            }
            if(!isChanged) {
                break;
            }
        }
 
        return result;
    }
 
    @Override
    public String toString() {
        return heap.toString();
    }
}