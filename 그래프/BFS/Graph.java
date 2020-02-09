package Data_Structure.그래프.BFS;

import java.util.*;

public class Graph {
    private int v; //노드의 개수
    private LinkedList<Integer> adj[]; //인접 리스트
    //자바는 배열의 크기를 미리 선언할 수 없다.

    public Graph(int k) {
        v = k;
        adj = new LinkedList[v];  // 배열만들 때 와 같은 문법이라고 생각하자 ( 조금 헷갈렸던 문법 )
        for (int i = 0; i < v; i++) {   //인접리스트 초기화
            adj[i] = new LinkedList();
        }
    }

    //노드를 연결 v->w
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int s) {
        boolean visited[] = new boolean[v];  // b를 대문자로 하나 소문자로 하나 어떤 차이지?
        LinkedList<Integer> q = new LinkedList<Integer>();

        visited[s] = true; // 방문 한 곳은 true
        q.add(s);
        // s는 시작 노드임

        while (q.size() != 0) {
            s = q.poll();   //방문한 곳은 출력
            System.out.print(s + " ");


            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
    }
}


