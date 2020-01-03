package Data_Structure.Heap;

public class MaxHeap {
    int value;
    int maxheap[];
    int heapsize = 0;

    public MaxHeap(){
        maxheap = new int[20];
        heapsize = 0;
    }

    public MaxHeap(int value){
        this.value = value;
    }

    void swap(MaxHeap a, MaxHeap b){
        int tmp = a.value;
        a.value = b.value;
        b.value = tmp;
    }

    void insert_max_heap(int x){
        int tmp;
        maxheap[++heapsize] = x;

        for(int i = heapsize; i > 1; i/=2){
            if(maxheap[i/2] < maxheap[i]){
                tmp = maxheap[i/2];
                maxheap[i/2] = maxheap[i];
                maxheap[i] = tmp;
            }
            else break;
        }
    }

    int delete_max_heap(){
        if(heapsize == 0) return 0;  // 배열이 빈 경우

        int item = maxheap[1];  //루트 노드의 값을 저장한다.
        //max_heap 에서 삭제 연산은 맨 위에 값을 삭제하고 다시 힙 구조를 이뤄야함
        maxheap[1] = maxheap[heapsize];  //마지막 노드를 루트 노드로 옮겨옴
        maxheap[heapsize--] = 0; //힙 크기를 줄이고 마지막 노드를 0으로 초기화 시키고 제거

        for(int i=1; i*2<=heapsize;){
            if(maxheap[i] > maxheap[i*2] && maxheap[i] > maxheap[i*2+1]){
                break;
                //만약 맨 마지막 노드가 루트의 왼쪽 + 오른쪽 자식보다 크다면 break
            }
            else if(maxheap[i*2] > maxheap[i*2+1]){
                int tmp = maxheap[i*2];
                maxheap[i*2] = maxheap[i];
                maxheap[i] = tmp;
                i = i * 2;  //왼쪽 자식이랑 옮겼으니 곱하기 2만 하기
            }
            else{
                int tmp = maxheap[i*2+1];
                maxheap[i*2+1] = maxheap[i];
                maxheap[i] = tmp;
                i = i * 2 + 1 ;  //오른쪽 자식이랑 옮겼으니 곱하기 2 && +1 하기
            }

        }
        return item;
    }
}
