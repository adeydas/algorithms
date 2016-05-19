package ws.abhis.education.old;

/**
 * Created by abhishek on 2/9/15.
 * Website: adeydas.com
 */
public class GraphEdge {
    public int src, dest;

    public int edgeWeight;
    public GraphNode end, start;

    public GraphEdge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }

    public GraphEdge(){}
}
