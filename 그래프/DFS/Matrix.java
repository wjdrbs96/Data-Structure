package Data_Structure.DFS;

public class Matrix {
    boolean visited[];  //노드를 방문할 때 true, false 담을 곳
    int V;  //정점의 개수
    int adj[][];  //matrix (인접행렬)

    public Matrix(int v){
        V=v;
        adj = new int[V][V];
        visited = new boolean[V];
    }

    void addEdge(int v1, int v2){
        if(v1 > V || v2 > V){
            System.out.println("값이 잘못되었습니다");
        }
        else{
            adj[v1][v2] = 1;
        }
    }

    void DFS(int v){
        visited[v] = true;
        System.out.print(v + " ");

        for(int i=0; i<V; i++){
            if(!visited[i] && adj[v][i]==1){
                DFS(i);
            }
        }
    }
}
