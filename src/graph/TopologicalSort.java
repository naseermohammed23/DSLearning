package graph;

public class TopologicalSort {


    public static void main(String[] args) {

        Graph graph = new Graph(6);

        //reverse dependency graph.. 
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, null);
        graph.addEdge(4, null);
        graph.addEdge(5, null);

        System.out.println("Reverse Dependency Graph : ");
        graph.topologicalSort();
    }

    
}
