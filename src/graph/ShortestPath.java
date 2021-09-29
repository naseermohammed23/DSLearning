package graph;


public class ShortestPath {


    public static void main(String[] args) {

        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, null);

        System.out.println("Shortest Path : " + graph.shortestPath(0, 3));
    }
}
