package Data_Structure.BFS;

public class Test {
    public static void main(String[] args){
        GraphMatrix m = new GraphMatrix(5);

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

        m.BFS(2);
    }
}
