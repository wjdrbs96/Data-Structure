package Data_Structure.트리.BST.School.탐색과제.B;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RedBlackTree {

    public RedBlackTree( ) {
        header      = new RedBlackNode( null );
        header.left = header.right = nullNode;
    }

    private final int compare( Comparable item, RedBlackNode t ) {
        if( t == header )
            return 1;
        else
            return item.compareTo( t.element );
    }

    public void insert( Comparable item ) {
        current = parent = grand = header;
        nullNode.element = item;

        while( compare( item, current ) != 0 ) {
            great = grand; grand = parent; parent = current;
            current = compare( item, current ) < 0 ? current.left : current.right;

            if( current.left.color == RED && current.right.color == RED )
                handleReorient( item );
        }

        if( current != nullNode )
            throw new DuplicateItemException( item.toString( ) );
        current = new RedBlackNode( item, nullNode, nullNode );

        if( compare( item, parent ) < 0 )
            parent.left = current;
        else
            parent.right = current;
        handleReorient( item );
    }


    public void remove( Comparable x ) {
        throw new UnsupportedOperationException( );
    }


    public void printTree( ) {
        printTree( header.right );
    }

    // 트리 전부를 출력하는 메소드
    private void printTree( RedBlackNode t ) {
        if( t != nullNode ) {
            printTree( t.left );
            System.out.println( t.element );
            printTree( t.right );
        }
    }


    private void handleReorient( Comparable item ) {
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;

        if( parent.color == RED )
        {
            grand.color = RED;
            if( ( compare( item, grand ) < 0 ) != ( compare( item, parent ) < 0 ) ) parent = rotate( item, grand );
            current = rotate( item, great );
            current.color = BLACK;
        }

        header.right.color = BLACK;
    }


    private RedBlackNode rotate( Comparable item, RedBlackNode parent ) {
        if( compare( item, parent ) < 0 )
            return parent.left = compare( item, parent.left ) < 0 ?
                    rotateWithLeftChild( parent.left )  :  // LL
                    rotateWithRightChild( parent.left ) ;  // LR
        else
            return parent.right = compare( item, parent.right ) < 0 ?
                    rotateWithLeftChild( parent.right ) :  // RL
                    rotateWithRightChild( parent.right );  // RR
    }

    private static RedBlackNode rotateWithLeftChild( RedBlackNode k2 ) {
        RedBlackNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    private static RedBlackNode rotateWithRightChild( RedBlackNode k1 ) {
        RedBlackNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }

    // 깊이를 출력하는 메소드
    public int maximum_depth(RedBlackNode root) {
        if (root == null) return 0;                   // node가 null이면 0을 리턴
        int left_depth = maximum_depth(root.left);
        int right_depth = maximum_depth(root.right);

        return Math.max(left_depth, right_depth) + 1;	// 해당 node가 root인 subtree의 depth를 리턴
    }

    // 검색하는 메소드
    public Comparable find( Comparable x ) {
        nullNode.element = x;
        current = header.right;

        for( ; ; ) {
            if( x.compareTo( current.element ) < 0 )
                current = current.left;
            else if( x.compareTo( current.element ) > 0 )
                current = current.right;
            else if( current != nullNode )
                return current.element;
            else
                return null;
        }
    }

    private static class RedBlackNode {

        RedBlackNode( Comparable theElement ) {
            this( theElement, null, null );
        }

        RedBlackNode( Comparable theElement, RedBlackNode lt, RedBlackNode rt ) {
            element  = theElement;
            left     = lt;
            right    = rt;
            color    = RedBlackTree.BLACK;
        }

        Comparable   element;
        RedBlackNode left;
        RedBlackNode right;
        int          color;
    }

    private RedBlackNode header;
    private static RedBlackNode nullNode;
    static {
        nullNode = new RedBlackNode( null );
        nullNode.left = nullNode.right = nullNode;
    }

    private static final int BLACK = 1;
    private static final int RED   = 0;

    private static RedBlackNode current;
    private static RedBlackNode parent;
    private static RedBlackNode grand;
    private static RedBlackNode great;


    public static void main( String[] args ) throws IOException {
        RedBlackTree t = new RedBlackTree( );

        File file = new File("C:\\Java\\src\\Data_Structure\\트리\\BST\\School\\탐색과제\\B\\CARRIERS.txt");

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";

        while ((line = bufferedReader.readLine()) != null) {              // 파일 한줄 씩 읽어오기
            String[] sp = line.split("\t");                        // \t을 기준으로 문자열 분리
            t.insert(sp[0]);
        }

        // 5개 항공사 검색

        String[] list = {"XPA", "Y2", "ZE", "TRA", "SOE"};

        System.out.println("5개 항공사를 검색합니다");
        for (int i = 0; i < list.length; ++i) {
            // 검색 결과가 맞으면 매게변수로 넣은 값과 동일 한 값이 찍힘
            System.out.println(list[i] + " : " + t.find(list[i]));
        }

        System.out.println("=======================");

        // 트리 전부 출력
        t.printTree();

        // 트리 깊이 출력
        //t.maximum_depth(t.header);
    }
}

class DuplicateItemException extends RuntimeException {

    public DuplicateItemException( ) {
        super( );
    }

    public DuplicateItemException( String message ) {
        super( message );
    }
}
