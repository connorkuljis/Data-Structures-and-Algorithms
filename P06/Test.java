import java.util.*;

public class Test 
{
    public static void main(String[] args)
    {
        DSAGraph theGraph = new DSAGraph();
        theGraph.addVertex("A", 1);
        theGraph.addVertex("B", 1);
        theGraph.addVertex("C", 0);

        theGraph.addEdge("A", "B");
        theGraph.addEdge("A", "C");
        theGraph.addEdge("B", "C");

        theGraph.display();
        theGraph.displayAdjacencyList();
    }
}
