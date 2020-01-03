package Data_Structure.Graph;

public class AdjMatrix {
    int matrix[][];
    int vertexSize;

    public AdjMatrix(){
        matrix = new int[50][50];
        vertexSize = 0;
    }

    public void insertVertex(int v){
        if(v >= 50){
            System.out.println("정점의 개수를 초과했습니다");
        }
        else{
            vertexSize++;
        }
    }

    public void insertEdge(int v1, int v2){
        if(v1 >= vertexSize || v2 >= vertexSize){
            System.out.println("값이 올바르지 않습니다");
        }
        else{
            matrix[v1][v2] = 1;
        }
    }

    public void printAdjMatrix(){
        for(int i=0; i<vertexSize; i++){
            for(int j=0; j<vertexSize; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

