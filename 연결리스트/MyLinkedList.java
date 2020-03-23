package Data_Structure.연결리스트;

public class MyLinkedList {

    private Node headNode;
    private int size;

    public MyLinkedList() {
        headNode = new Node();
        size = 0;
    }

    public void addFirst(Object data) {
        Node newNode = new Node(data);
        newNode.nextNode = headNode.nextNode;
        headNode.nextNode = newNode;
        size++;
    }

    public Object get(int index) {
        return getNode(index).data;
    }

    public Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index : " + index + " size : " + size);
        }

        Node node = headNode.nextNode;
        for (int i = 0; i < index; i++) {
            node = node.nextNode;
        }

        return node;
    }

    public void add(int index, Object data) {
        if (index <= 0 || index >= size) {
            throw new IndexOutOfBoundsException("index : " + index + " size : " + size);
        }

        Node newNode = new Node(data);
        Node preNode = getNode(index - 1);
        newNode.nextNode = preNode.nextNode;
        preNode.nextNode = newNode;
        size++;
    }

    public void addLast(Object data) {
        add(size - 1, data);
    }

    public Object removeFirst() {
        Node node = headNode.nextNode;
        headNode.nextNode = node.nextNode;
        Object result = node.data;
        node = null;
        size--;
        return result;
    }

    public Object remove(int index) {
        if (index <= 0 || index >= size) {
            throw new IndexOutOfBoundsException("index : " + index + " size : " + size);
        }

        if (index == 0) {
            return removeFirst();
        }
        Node preNode = getNode(index - 1);
        Node removeNode = preNode.nextNode;
        Node postNode = removeNode.nextNode;
        preNode.nextNode = postNode;
        Object result = removeNode.data;
        removeNode = null;
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node node = headNode.nextNode;
        if (node == null) {
            result.append("No Data");
        }
        else {
            result.append(node.data);
            node = node.nextNode;
            while (node != null) {
                result.append(", ");
                result.append(node.data);
                node = node.nextNode;
            }
        }
        result.append("]");
        return result.toString();
    }

    private class Node {

        private Node nextNode;
        private Object data;

        Node() {
        }

        Node(Object data) {
            this.nextNode = null;
            this.data = data;
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.addFirst(500);
        list.addFirst(400);
        list.addFirst(300);
        list.addFirst(200);
        list.addFirst(100);

        System.out.println(list.toString());
        // 100 200 300 400 500

        list.add(1, 150);
        System.out.println(list.toString());
        // 100 150 200 300 400 500

        list.remove(1);
        System.out.println(list.toString());
        // 100 200 300 400 500

        System.out.println(list.size()); // 5

        list.removeFirst();
        System.out.println(list.toString()); // 200 300 400 500
        System.out.println(list.get(2)); // 400

    }
}
