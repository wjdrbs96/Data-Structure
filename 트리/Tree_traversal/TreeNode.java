package Data_Structure.트리.Tree_traversal;

public class TreeNode {
    Object data;
    TreeNode left;
    TreeNode right;

    public TreeNode(Object data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Object getData(){
        return this.data;
    }
}
