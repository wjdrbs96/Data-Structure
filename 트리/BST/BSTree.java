package Data_Structure.BST;

public class BSTree {
    TreeNode root = null; //일단 깡통 몸체를 구현함

    public TreeNode insertKey(TreeNode root, int data){
        TreeNode p = root;
        TreeNode newNode = new TreeNode(data);

        if(p == null){   //가장 처음 값을 insert 할 때 생김
            return newNode;
        }
        else if(p.data > newNode.data){  //루트 키 값보다 작으면 왼쪽
            p.left = insertKey(p.left,data);
            return p;
        }
        else if(p.data < newNode.data){  //루트 키 값보다 크면 오른쪽
            p.right = insertKey(p.right,data);
            return p;
        }
        else{
            return p;
        }
    }

    public void insertBST(int data){
        root = insertKey(root,data);
    }

    public boolean deleteBST(int x){
        //현재 위치로부터의 루트 노드
        TreeNode parent = root;
        TreeNode current = root;

        boolean isLeftChild = false;
        while(current.data != x){
            parent = current;
            if(current.data > x){
                isLeftChild = true;
                current = current.left;
            }
            else if(current.data < x){
                isLeftChild = false;
                current = current.right;
            }
            if(current == null){
                System.out.println("트리가 존재하지 않습니다");
                return false;
            }
        }
        //여기까지 while이 돌고나면 x의 위치 찾음

        // 1. 자식노드가 없는 경우(단말노드)

        if(current.left == null && current.right == null){
            if(current == root){   // 트리 전체에서 노드가 루트 하나인 경우
                root = null;
            }
            //단말 노드와 연결을 끊음
            if(isLeftChild){
                parent.left = null;
            }
            else{
                parent.right = null;
            }
        }
        // 2. 하나의 자식을 갖는 경우
        //왼쪽 자식을 갖는 경우
        else if(current.right == null){
            if(current == root){
                root = current.left;
            }
            else if(isLeftChild){
                parent.left = current.left;
            }
            else{
                parent.right = current.left;
            }
        }
        //오른쪽 자식을 갖는 경우
        else if(current.left == null){
            if(current == root){
                root = current.right;
            }
            else if(isLeftChild){  //루트 노드를 기준으로 왼쪽으로 갔을 때
                parent.left = current.right;
            }
            else{  //루트 노드를 기준으로 오른쪽으로 갔을 때
                parent.right = current.right;
            }
        }
        //3. 두개의 자식을 갖는 경우
        else if(current.left != null && current.right != null){
            TreeNode suc = getSuc(current);
            if(current == root){
                root = suc;   //삭제 할 노드가 root 라면 root 자리에 current 놓기
            }
            else if(isLeftChild){  //삭제 할 노드의 위치가 루트를 기준으로 왼쪽이라면
                parent.left = suc; //자기 자리에 suc 을 대입
            }
            else{
                parent.right = suc;
            }
            suc.left = current.left;  // current 는 삭제할 노드
            //suc 은 삭제할 노드의 위치를 대체 할 노드
            //삭제할 노드의 왼쪽 서브트리를 새로운 대체 노드의 왼쪽 서브트리로 만듬
            //대체 노드를 삭제 노드 기준으로 오른쪽 서브트리 중에 가장 작은 것을 선택했기 때문
        }
        return true;  //위에서 존재하지 않으면 return false 문이 있기 때문에 삭제를 성공하면 return true
    }

    public TreeNode getSuc(TreeNode deleteNode){
        TreeNode suc = null;
        TreeNode sucparent = null;
        TreeNode current = deleteNode.right;

        //오른쪽 서브트리에서 가장 작은 값을 찾는 과정
        while(current != null){
            sucparent = suc;
            suc = current;
            current = current.left;
        }

        if(suc != deleteNode.right){
            sucparent.left = suc.right;
            suc.right = deleteNode.right;
        }
        return suc;  // 삭제 할 노드 위치에 올 노드를 반환
    }

    public TreeNode SearchTree(int data){
        TreeNode p = root;
        while(p != null){
            if(data < p.data){
                p = p.left;
            }
            else if(data > p.data){
                p = p.right;
            }
            else{
                return p;
            }
        }
        return p;
    }

    public void inorder(TreeNode root){
        if(root != null){
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
}
