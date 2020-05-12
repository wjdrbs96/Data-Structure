package Data_Structure.트리.BST.School;

public class Test {
    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<String, Integer>();

        String[] keys = {"S", "E", "A", "R", "C", "H", "X", "M", "P", "L"};
        Integer[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for(int i = 0; i < keys.length; i++) {
            bst.insert(keys[i], values[i]);
        }

    }
}
