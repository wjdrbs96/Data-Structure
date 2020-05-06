package Data_Structure.그래프.List;

import java.util.ArrayList;
import java.util.List;

public class ListGraph {
    private List<ArrayList<Integer>> listGraph;

    public ListGraph(int initSize) {
        this.listGraph = new ArrayList<>();

        for (int i = 0; i < initSize + 1; ++i) {
            listGraph.add(new ArrayList<>());
        }
    }

    public List<Integer> getNode(int i) {
        return this.listGraph.get(i);
    }

    public void put(int start, int end) {
        listGraph.get(start).add(end);
        listGraph.get(end).add(start);
    }

    public void putSingle(int start, int end) {
        listGraph.get(start).add(end);
    }

    public void printGraphToAdjList() {
        for (int i = 1; i < listGraph.size(); ++i) {
            System.out.print("정점 " + i + "의 인접리스트");

            for (int j = 0; j < listGraph.get(i).size(); ++j) {
                System.out.print(" -> " + listGraph.get(i).get(j));
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int initSize = 6;
        ListGraph listGraph = new ListGraph(initSize);

        listGraph.put(1, 2);
        listGraph.put(1, 3);
        listGraph.put(2, 3);
        listGraph.put(2, 4);
        listGraph.put(3, 4);
        listGraph.put(3, 5);
        listGraph.put(4, 5);
        listGraph.put(4, 6);

        listGraph.printGraphToAdjList();
    }

}


