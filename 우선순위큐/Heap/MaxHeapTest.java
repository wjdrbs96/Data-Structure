package Data_Structure.우선순위큐.Heap;

import java.io.IOException;
import java.util.ArrayList;

public class MaxHeapTest {
    private ArrayList<Integer> heap;

    public MaxHeapTest() {
        heap = new ArrayList<>();
        heap.add(0);  // 인덱스 0번은 버림
    }

    public void insert(int val) {
        heap.add(val);
        int p = heap.size()-1;

        while (p > 1 && heap.get(p / 2) < heap.get(p)) {
            int temp = heap.get(p / 2);
            heap.set(p/2, heap.get(p));
            heap.set(p, temp);

            p = p / 2;
        }
    }

    public int delete() {
        if (heap.size()-1 < 1) {
            return 0;
        }

        int deleteItem = heap.get(1);
        heap.set(1,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int parent = 1;
        int child = 2;
        while (child < heap.size()) {
            int max = heap.get(child);

            if (child < heap.size()-1 && max < heap.get(child + 1)) {
                max = heap.get(child + 1);
                child++;
            }

            if (heap.get(parent) > max) {
                break;
            }

            int temp = heap.get(parent);
            heap.set(parent, heap.get(child));
            heap.set(child, temp);
            parent = child;
            child+=2;

        }
        return deleteItem;

    }

    public static void main(String[] args) throws IOException {
        MaxHeapTest heap = new MaxHeapTest();
        heap.insert(9);
        heap.insert(2);
        heap.insert(4);
        heap.insert(1);
        heap.insert(7);

        for (int i = 0; i < 5; ++i) {
            System.out.println(heap.delete());
        }
    }
}
