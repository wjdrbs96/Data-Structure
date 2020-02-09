package Data_Structure.스택;

class Stack {
    int top;
    int[] stack;
    int size;

    public Stack(int size) {
        top = -1;
        stack = new int[size];
        this.size = size;
    }

    public int peek() {
        return stack[top];
    }

    public void push(int data) {
        stack[++top] = data;
    }

    public int pop() {
        return stack[top--];
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        else {
            return false;
        }
    }

}

public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(1); stack.push(2);
        stack.push(3); stack.push(4);
        stack.push(5); stack.push(6);
        stack.push(7); stack.push(8);

        System.out.println(stack.peek());
        for (int i = 0; i < 8; ++i) {
            System.out.print(stack.pop() + " ");
        }

    }
}
