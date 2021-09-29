package graph;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Deque;

public class Graph {

    static class HopCount {
        Integer node; 
        int count;

        HopCount(Integer node, int count) {
            this.node = node;
            this.count = count;
        }
    }
    
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

    void dfs(int v, boolean[] isVisited) {

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

    boolean isCycle() {
        boolean[] isVisited = new boolean[V];
        boolean[] isAlive = new boolean[V];

        for (int i=0;i<adjList.length;i++) {
            if (!isVisited[i]) {
                return dfsCycle(i, isVisited, isAlive);
            }
        }

        return false;
    }

    boolean dfsCycle(int v, boolean[] isVisited, boolean[] isAlive) {
        isVisited[v] = true;
        isAlive[v] = true;

        LinkedList<Integer> list = adjList[v];
        if (list != null) {
            for (Integer c : list) {
                if (c != null && !isVisited[c]) {
                    if (dfsCycle(c, isVisited, isAlive)) {
                        return true;
                    }
                }

                if (c != null && isVisited[c] && isAlive[c]) { // if visited and isAlive then there is a cycle.. 
                    return true; // if cycle just simple return .. 
                }
            }
        }

        isAlive[v] = false;
        

        return false;
    }

    public int shortestPath(int src, int dest) {
        boolean[] isVisited = new boolean[V];

        Deque<HopCount> q = new ArrayDeque<HopCount>();

        q.offer(new HopCount(src, 0));
        isVisited[src] = true;

        while (!q.isEmpty()) {
            HopCount v = q.poll();
            if (v.node == dest) { //we found out destination node
                return v.count;
            }

            LinkedList<Integer> list = adjList[v.node];

            if (list != null) {
                for (Integer c : list) {
                    if (c != null) {
                        if (!isVisited[c]) {
                            q.offer(new HopCount(c, v.count+1));
                            isVisited[c] = true;
                        }
                    }
                }
            }

        }

        return -1;
    }
}
