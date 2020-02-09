package Data_Structure.트리.Tree_traversal;

public class TreeTest {
    public static void main(String[] args){
        LinkedTree tree = new LinkedTree();

        TreeNode n7 = tree.makeBT(null,'D',null);
        TreeNode n6 = tree.makeBT(null,'C',null);
        TreeNode n5 = tree.makeBT(null,'B',null);
        TreeNode n4 = tree.makeBT(null,'A',null);
        TreeNode n3 = tree.makeBT(n6,'/',n7);
        TreeNode n2 = tree.makeBT(n4,'*',n5);
        TreeNode n1 = tree.makeBT(n2,'-',n3);

        System.out.println("preorder");
        tree.preorder(n1);
        System.out.println();
        System.out.println("inroder");
        tree.inorder(n1);
        System.out.println();
        System.out.println("postorder");
        tree.postorder(n1);
    }
}
