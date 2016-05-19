package ws.abhis.education.old;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Given a number of friends who have to give or take some amount of money from one another.
 * Design an algorithm by which the total cash flow among all the friends is minimized.
 */
public class AP_3 {

    private int leastWeight = Integer.MAX_VALUE;
    public GraphNode leastWeightNode;
    public Set<GraphNode> visitedNodes = new HashSet<GraphNode>();
    public Set<GraphNode> notVisited = new HashSet<GraphNode>();

    //Find the node with the least weighted outgress
    public void findStartNode(GraphNode anyNode) {
        if (!visitedNodes.contains(anyNode) && anyNode != null) {
            GraphEdge[] edges = anyNode.edges;
            for (GraphEdge edge : edges) {
                if (edge.edgeWeight < leastWeight) {
                    leastWeight = edge.edgeWeight;
                    leastWeightNode = anyNode;
                }
                visitedNodes.add(anyNode);
                findStartNode(edge.end);
            }
        }
    }

    public int minimalCashFlow = 0;

    //Apply Djisktra's to calculate total minimal cash flow
    public void calculateCashFlow(GraphNode node) {
        if (!visitedNodes.contains(node) && node != null) {
            GraphEdge[] edges = node.edges;
            int localLeastWeight = Integer.MAX_VALUE;
            GraphNode nextNode = null;
            for (GraphEdge edge : edges) {
                if (edge.edgeWeight < localLeastWeight) {
                    nextNode = edge.end;
                    localLeastWeight = edge.edgeWeight;
                } else {
                    notVisited.add(edge.end);
                }
            }
            minimalCashFlow += localLeastWeight;
            visitedNodes.add(node);
            calculateCashFlow(nextNode);
        }
    }

    public static void main(String... args) {
        GraphNode A = new GraphNode();
        GraphNode B = new GraphNode();
        GraphNode C = new GraphNode();
        GraphNode D = new GraphNode();

        GraphEdge ge1000 = new GraphEdge();
        ge1000.start = A;
        ge1000.end = B;
        ge1000.edgeWeight = 1000;


        GraphEdge ge3000 = new GraphEdge();
        ge3000.start = B;
        ge3000.end = C;
        ge3000.edgeWeight = 3000;

        GraphEdge ge2000 = new GraphEdge();
        ge2000.start = C;
        ge2000.end = A;
        ge2000.edgeWeight = 2000;

        GraphEdge ge5000 = new GraphEdge();
        ge5000.start = C;
        ge5000.end = D;
        ge5000.edgeWeight = 5000;

        GraphEdge ge4000 = new GraphEdge();
        ge4000.start = D;
        ge4000.end = A;
        ge4000.edgeWeight = 4000;

        A.edges = new GraphEdge[] {ge1000};
        B.edges = new GraphEdge[] {ge3000};
        C.edges = new GraphEdge[] {ge2000, ge5000};
        D.edges = new GraphEdge[] {ge4000};

        AP_3 ap_3 = new AP_3();

        ap_3.findStartNode(A);
        ap_3.visitedNodes.clear();
        ap_3.calculateCashFlow(ap_3.leastWeightNode);

        Iterator it = ap_3.notVisited.iterator();
        while (it.hasNext()) {
            GraphNode node = (GraphNode) it.next();
            ap_3.findStartNode(node);
            ap_3.visitedNodes.clear();
            ap_3.calculateCashFlow(ap_3.leastWeightNode);
        }


        System.out.println(ap_3.minimalCashFlow);
    }
}
