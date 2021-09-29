package graph;

public class GraghDFSBFS {

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
        graph.addEdge(2, 0); // cycle in the graph.. 

        System.out.println("Printing the Graph using BFS ... ");
        
        graph.printGraphUsingBFS();
       
        System.out.println();
        System.out.println("Printing the Graph using DFS ... ");
        
        graph.printGraphUsingDFS();

        System.out.println();
        System.out.println("Cycle exist in the Graph - " + graph.isCycle());
    }

}
