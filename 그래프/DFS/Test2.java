package Data_Structure.DFS;

public class Test2 {
    public static void main(String[] args){
        Matrix m = new Matrix(5);

        m.addEdge(0,1);
        m.addEdge(4,1);
        m.addEdge(4,3);
        m.addEdge(0,4);
        m.addEdge(0,3);
        m.addEdge(0,2);
        m.addEdge(1,2);
        m.addEdge(2,0);
        m.addEdge(2,3);
        m.addEdge(3,3);

        m.DFS(2);
    }
}
