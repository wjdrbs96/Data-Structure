package Data_Structure.그래프.Matrix;

public class Test {
    public static void main(String[] args){
        AdjMatrix m = new AdjMatrix();
        for(int i = 0; i < 4;i++){
            m.insertVertex(i);
        }

        m.insertEdge(0, 3);
        m.insertEdge(0, 1);
        m.insertEdge(1, 3);
        m.insertEdge(1, 2);
        m.insertEdge(1, 0);
        m.insertEdge(2, 3);
        m.insertEdge(2, 1);
        m.insertEdge(3, 2);
        m.insertEdge(3, 1);
        m.insertEdge(3, 0);

        m.printAdjMatrix();

        AdjList l = new AdjList();
        for(int i = 0; i < 4; i++){
            l.insertVertex(i);
        }

        l.insertEdge(0, 3);
        l.insertEdge(0, 1);
        l.insertEdge(1, 3);
        l.insertEdge(1, 2);
        l.insertEdge(1, 0);
        l.insertEdge(2, 3);
        l.insertEdge(2, 1);
        l.insertEdge(3, 2);
        l.insertEdge(3, 1);
        l.insertEdge(3, 0);

        System.out.println("그래프 G의 인전행렬 : ");
        l.printAjdList();

    }
}
