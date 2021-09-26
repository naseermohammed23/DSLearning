package graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Deque;

public class GraghDFSBFS {

    static class Graph {

        int V; // no of nodes or vertices..

        // Array of LinkedList with each index as a vertex.
        LinkedList<Integer>[] adjList;

        public Graph(int v) {
            this.V = v;
            adjList = new LinkedList[v];
        }

        public void addEdge(int v, Integer c) {

            LinkedList<Integer> list = adjList[v];
            if (list == null) {
                list = new LinkedList<>();
            }

            list.add(c);
            adjList[v] = list;

        }

        void printGraphUsingBFS() {
            boolean[] isVisited = new boolean[V];

            Deque<Integer> q = new ArrayDeque<Integer>();
            for (int i = 0; i < adjList.length; i++) {

                if (!isVisited[i]) {
                    q.offer(i);
                    isVisited[i] = true;
                }

                while (!q.isEmpty()) {
                    Integer v = q.poll();
                    System.out.print(v + " ");

                    LinkedList<Integer> list = adjList[v];

                    if (list != null) {
                        for (Integer c : list) {
                            if (c != null) {
                                if (!isVisited[c]) {
                                    q.offer(c);
                                    isVisited[c] = true;
                                }
                            }
                        }
                    }

                }

            }

        }

        void printGraphUsingDFS() {
            boolean[] isVisited = new boolean[V];

            for (int i=0;i<adjList.length; i++) {
                if (!isVisited[i]) {
                    dfs(i, isVisited);
                }
            }
        }

        private void dfs(int v, boolean[] isVisited) {

            isVisited[v] = true;
            System.out.print(v + " ");


            LinkedList<Integer> list = adjList[v];

            if (list != null) {
                for (Integer c : list) {
                    if (c != null && !isVisited[c]) {
                        dfs(c, isVisited);                        
                    }
                }
            }

        }
    }

    public static void main(String[] args) {

        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, null);
        graph.addEdge(4, null);
        graph.addEdge(5, 2);

        System.out.println("Printing the Graph using BFS ... ");
        
        graph.printGraphUsingBFS();
       
        System.out.println();
        System.out.println("Printing the Graph using DFS ... ");
        
        graph.printGraphUsingDFS();
    }

}
