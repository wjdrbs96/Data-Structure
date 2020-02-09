package Data_Structure.그래프.BFS;

import java.util.Queue;
import java.util.LinkedList;

public class GraphMatrix {
    boolean visited[];
    int V;  //정점의 수
    int adj[][];

    public GraphMatrix(int v){
        V = v;
        visited = new boolean[V];
        adj = new int[V][V];
    }

    void addEdge(int v1, int v2){
        if(v1 > V || v2 > V){
            System.out.println("잘못 됐습니다");
        }
        else{
            adj[v1][v2] = 1;
        }
    }

    void BFS(int v){  //인접행렬을 이용해서 BFS 구현하기
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(v);
        visited[v] = true;
        System.out.print(v + " ");
        while(!q.isEmpty()){
            v = q.poll();
            for(int w=0; w<V; w++){
                if(adj[v][w] ==1 && !visited[w]){
                    visited[w] = true;
                    System.out.print(w + " ");
                    q.offer(w);
                }
            }
        }
    }
}
