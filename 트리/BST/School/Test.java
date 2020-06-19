package Data_Structure.트리.BST.School;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<String, Integer>();

        String[] keys = {"S", "E", "A", "R", "C", "H", "X", "M", "P", "L"};
        Integer[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for(int i = 0; i < keys.length; i++) {
            bst.insert(keys[i], values[i]);
        }

        bst.inorder();
        System.out.println("Height of the BST : " + bst.height());
        System.out.println("Key of the root node : " + bst.getRooKey());

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your search key : ");
        String search_key = input.next();
        if (bst.search(search_key) == null) {
            System.out.println("-> No such key!");
        }
        else {
            System.out.println("=> " + bst.getValue(bst.search(search_key)));
        }

        input.close();
    }
}
