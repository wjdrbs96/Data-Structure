package Data_Structure.트리.BST.School.탐색과제.B;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Integer.max;

public class RbTree {
    TreeNode Root = null;

    int HeightT(TreeNode Root) {

        int lefth, righth;
        if (Root == null || (Root.children == null && Root.children[1] == null)) {
            return 0;
        }
        lefth = HeightT(Root.children[0]);
        righth = HeightT(Root.children[1]);

        return (max(lefth, righth) + 1);
    }

    int check(int dir) {
        return dir == 0 ? 1 : 0;
    }

    boolean isRed(TreeNode Node) {
        return Node != null && Node.color.equals("R");
    }

    TreeNode SingleRotate(TreeNode Node, int dir) {
        TreeNode temp = Node.children[check(dir)];
        Node.children[check(dir)] = temp.children[dir];
        temp.children[dir] = Node;
        Root.color = "R";
        temp.color = "B";

        return temp;
    }

    TreeNode DoubleRotate(TreeNode Node, int dir) {
        Node.children[check(dir)] = SingleRotate(Node.children[check(dir)], check(dir));
        return SingleRotate(Node, dir);
    }

    TreeNode Insert(RbTree tree, String data) {
        if (tree.Root == null) {
            tree.Root = new TreeNode(data);

            if (tree.Root == null)
                return null;
        }
        else {
            TreeNode temp = new TreeNode("");

            TreeNode g, t;
            TreeNode p, q;

            int dir = 0, last = 0;
            t = temp;
            g = p = null;

            t.children[1] = tree.Root;

            q = t.children[1];

            while (true) {
                if (q == null) { q = new TreeNode(data);
                    p.children[dir] = q;
                }

                else if (isRed(q.children[0]) && isRed(q.children[1])) {
                    q.color = "R";
                    q.children[0].color = "B";
                    q.children[1].color = "B";
                }

                if (isRed(q) && isRed(p)) {

                    int dir2;
                    if (t.children[1] == g) {
                        dir2 = 1;
                    }
                    else {
                        dir2 = 0;
                    }

                    if (q == p.children[last]) {
                        t.children[dir2] = SingleRotate(g, last == 0 ? 1 : 0);
                    }

                    else {
                        t.children[dir2] = DoubleRotate(g, last == 0 ? 1 : 0);
                    }
                }

                if (q.data.equals(data)) {
                    break;
                }
                last = dir;

                dir = q.data.compareTo(data) < 0 ? 1 : 0;

                if (g != null) {
                    t = g;
                }

                g = p;
                p = q;
                q = q.children[dir];
            }

            tree.Root = temp.children[1];
        }

        tree.Root.color = "B";

        return tree.Root;
    }

    void PrintLevel(TreeNode root, int i) {
        if (root == null) {
            return;
        }

        if (i == 1) {
            System.out.print("| " + root.data + " | " + root.color + " |");

            if (root.children[0] != null) {
                System.out.print(" " + root.children[0].data + " |");
            }
            else {
                System.out.print(" " + "NULL" + " |");
            }
            if (root.children[1] != null) {
                System.out.print(" " + root.children[1].data + " |");
            }
            else {
                System.out.print(" " + "NULL" + " |");
            }

            System.out.print(" ");

            return;
        }

        PrintLevel(root.children[0], i - 1);
        PrintLevel(root.children[1], i - 1);
    }

    void LevelOrder(TreeNode root) {
        int i;

        for (i = 1; i < HeightT(root) + 1; i++) {
            PrintLevel(root, i);
            System.out.print("\n\n");
        }
    }

}

class TreeNode {

    String data, color;
    TreeNode children[];

    public TreeNode(String data) {
        this.data = data;
        this.color = "R";
        children = new TreeNode[2];
        children[0] = null;
        children[1] = null;
    }
}

class Driver {
    public static void main(String[] args) throws IOException {
        RbTree Tree = new RbTree();

        File file = new File("C:\\Java\\src\\Data_Structure\\트리\\BST\\School\\탐색과제\\B\\CARRIERS.txt");

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        List<TreeNode> list = new LinkedList<>();

        while ((line = bufferedReader.readLine()) != null) {              // 파일 한줄 씩 읽어오기
            String[] sp = line.split("\t");                        // \t을 기준으로 문자열 분리
            Tree.Root = Tree.Insert(Tree, sp[0]);
            list.add(new TreeNode(sp[0]));
        }

        for (int i = 0; i < list.size(); ++i) {
            Tree.LevelOrder(list.get(i));
        }
    }
}
