package Data_Structure.트리.BST;

public class Test {
    public static void main(String[] args){
        BSTree bst = new BSTree();
        bst.insertBST(5);
        bst.insertBST(10);
        bst.insertBST(11);
        bst.insertBST(8);
        bst.insertBST(7);
        bst.insertBST(9);
        TreeNode p1 = bst.SearchTree(10);
        if(p1 != null){
            System.out.println("탐색 성공");
        }
        else{
            System.out.println("탐색 실패");
        }




    }
}
