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
        System.out.println("root : " + root.key);
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
}