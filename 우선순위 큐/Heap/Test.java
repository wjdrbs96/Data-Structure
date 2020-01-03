package Data_Structure.Heap;

public class Test {
    public static void main(String[] args){
        MaxHeap heap = new MaxHeap();
        heap.insert_max_heap(10);
        heap.insert_max_heap(5);
        heap.insert_max_heap(30);
        heap.insert_max_heap(21);
        heap.insert_max_heap(17);

        //삭제 연산
        for(int i=1; i<=5; i++){
            System.out.print(heap.delete_max_heap() + " ");
        }
    }
}
