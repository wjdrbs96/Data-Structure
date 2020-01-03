package Data_Structure.DFS;

import java.util.LinkedList;

public class Graph {
    public int V;   //노드의 개수
    public LinkedList<Integer>[] adj;  //인접 리스트
    boolean[] visited;

    //생성자
    public Graph(int v){
        V = v;
        adj = new LinkedList[v];
        visited = new boolean[V];

        for(int i=0; i<v; i++){
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void DFS(int v){   //순환 호출을 이용해서 구현
        visited[v] = true;
        System.out.print(v + " ");

        for(int k : adj[v]){
            if(!visited[k]){
                DFS(k);     //순환 호출
            }
        }

    }
}
