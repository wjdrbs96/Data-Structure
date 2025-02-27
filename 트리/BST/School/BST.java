package Data_Structure.트리.BST.School;

public class BST <K extends Comparable<K>, V> {

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K k, V v) {
            this.key = k;
            this.val = v;
        }
    }

    private Node root;

    public void insert(K k, V v) {
        root = insert(root, k, v);
    }

    private Node insert(Node node, K k, V v) {
        if (node == null)
            return new Node(k, v);

        int cmp = k.compareTo(node.key);
        if (cmp < 0) node.left = insert(node.left, k, v);
        else if (cmp > 0) node.right = insert(node.right, k, v);
        else node.val = v;
        System.out.println(node.key + " node");
        return node;
    }

    private Node search(Node node, K k) {
        if (node == null) return null;
        int cmp = k.compareTo(node.key);
        if (cmp < 0) return search(node.left, k);
        else if (cmp > 0) return search(node.right, k);
        return node;
    }

    public Node search(K k) {
        return search(root, k);
    }

    private void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.key + " ");
        inorder(node.right);
    }

    public void inorder() {
        System.out.print("in-order : ");
        inorder(root);
        System.out.println("");
    }

    private int height(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int height() {
        return height(root);
    }

    public K getRooKey() {
        return root.key;
    }

    public V getValue(Node node) {
        return node.val;
    }
}