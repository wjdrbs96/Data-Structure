package Data_Structure.그래프.Matrix;

public class AdjList {
    public GraphNode[] headList;
    public int headListSize;

    public AdjList(){
        headList = new GraphNode[10];
    }

    public void insertVertex(int i){
        if(headListSize>=10){
            System.out.println("점점 개수 초과입니다");
        }
        else{
            headListSize++;
        }

    }

    public void insertEdge(int v1, int v2){
        if(v1>=headListSize || v2>=headListSize){
            System.out.println("vertex값이 올바르지 않습니다");
        }
        else{
            GraphNode gn = new GraphNode(v2);
            gn.link = headList[v1];
            headList[v1] = gn;

            GraphNode temp = headList[v1];
            int tmpValue;

            while(temp.link != null){
                if(temp.vertex > temp.link.vertex){
                    tmpValue = temp.vertex;
                    temp.vertex = temp.link.vertex;
                    temp.link.vertex = tmpValue;
                }
                temp = temp.link;
            }
        }
    }

    public void printAjdList(){
        for(int i=0; i<headListSize; i++){
            GraphNode tmp = headList[i];
            System.out.printf("정점 %d의 인접리스트",i);

            while(tmp.link!=null){
                System.out.printf("%d -> ",tmp.vertex);
                tmp = tmp.link;
            }
            System.out.printf("%d%n", tmp.vertex);

        }
    }

}
