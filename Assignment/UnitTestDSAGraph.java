public class UnitTestDSAGraph 
{
    public static void main(String[] args)
    {
	DSAGraph graph = new DSAGraph();
	graph.addVertex("A", null);
	graph.addVertex("B", null);
	graph.addVertex("C", null);
	graph.addVertex("D", null);
	
	graph.addEdge("A", "B", "a->b", null);
	graph.addEdge("A", "C", "a-c", null);
	graph.addEdge("B", "C", "b->c", null);
	graph.addEdge("C", "D", "c->d", null);
	graph.displayAdjacencyList();
	graph.displayVerticies();
	graph.displayEdges();

	DSAQueue dfs = graph.depthFirstSearch();
	DSAQueue bfs = graph.breadthFirstSearch();

	System.out.print("DFS : "); 
	for (Object e : dfs)
	{
	    System.out.print(((DSAGraphVertex)(e)).getLabel() + " "); 
	}
	System.out.println(""); 

	System.out.print("BFS : "); 
	for (Object e : bfs)
	{
	    System.out.print(((DSAGraphVertex)(e)).getLabel() + " "); 
	}
	System.out.println(""); 
	
    }
    
}
