package Data_Structure.트리.BST.School;

public class BST<K extends Comparable<K>, V> {

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

    public BST() {

    }

    private Node search(Node node, K k) {
        if (node == null) return null;
        int cmp = k.compareTo(node.key);

        if (cmp < 0) {
            return search(node.left, k);
        }
        else if (cmp > 0) {
            return search(node.right, k);
        }
        else {
            return node;
        }
    }



}
