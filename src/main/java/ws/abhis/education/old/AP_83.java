package ws.abhis.education.old;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a directed graph, detect if there exists a cycle in it.
 */
public class AP_83 {

    private Set<Integer> traversedEdges = new HashSet<Integer>();

    public boolean cycleExists(Graph graph) {
        for (int i=0; i<graph.E; i++) {
            if (traversedEdges.contains(graph.edges[i].src))
                return true;
            else
                traversedEdges.add(graph.edges[i].src);
        }
        return false;
    }

    public static void main(String... args) {
        GraphEdge zeroToTwo = new GraphEdge(0, 2);
        GraphEdge twoToZero = new GraphEdge(2, 0);
        GraphEdge twoToThree = new GraphEdge(2,3);
        GraphEdge threeToThree = new GraphEdge(3,3);
        GraphEdge zeroToOne = new GraphEdge(0,1);
        GraphEdge oneToTwo = new GraphEdge(1,2);

        Graph graph = new Graph();
        graph.V=4;
        graph.E=6;
        graph.edges = new GraphEdge[] {zeroToOne, twoToThree, twoToZero, zeroToTwo, threeToThree, oneToTwo};

        System.out.println(new AP_83().cycleExists(graph));
    }
}
