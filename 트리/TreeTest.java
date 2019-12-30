package Data_Structure;
//자바로 트리 구현하기
class TreeNode{
    Object data;
    TreeNode left;
    TreeNode right;

    public TreeNode(Object data){
        this.data = data;
        this.left = null;  // 이 부분이 조금 이해가 안되네
        this.right = null;
    }

    public void makeLeftSubTree(TreeNode sub){
        if(left != null){
            this.left = null;
        }
        this.left = sub;
    }

    public void makeRightSubTree(TreeNode sub){
        if(right != null){
            this.right = null;
        }
        this.right = sub;
    }
}
public class TreeTest {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);

        root.makeLeftSubTree(n1);
        root.makeRightSubTree(n2);
        n2.makeLeftSubTree(n3);


    }
}
