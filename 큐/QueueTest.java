package Data_Structure.큐;

class Queue {
    int front;
    int rear;
    int size;
    int[] queue;

    public Queue(int size) {
        front = 0;
        rear = -1;
        this.size = size;
        queue = new int[size];
    }

    public boolean isEmpty() {
        return (front == rear + 1);
    }

    public boolean full() {
        return (rear == size - 1);
    }

    public void Enqueue(int data) {
        queue[++rear] = data;
    }

    public int Dequeue() {
        return queue[front++];
    }


}

public class QueueTest {
    public static void main(String[] args) {
        Queue q = new Queue(8);
        q.Enqueue(1); q.Enqueue(2);
        q.Enqueue(3); q.Enqueue(4);
        q.Enqueue(5); q.Enqueue(6);
        q.Enqueue(7); q.Enqueue(8);

        for (int i = 0; i < q.size; ++i) {
            System.out.print(q.Dequeue() + " ");
        }


    }
}
