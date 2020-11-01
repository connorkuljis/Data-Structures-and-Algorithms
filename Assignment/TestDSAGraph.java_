public class TestDSAGraph 
{
    public static void main(String[] args)
    {

	DSAGraph graph = new DSAGraph();
	graph.addVertex("A", null);
	graph.addVertex("B", null);
	graph.addVertex("C", null);
	graph.addVertex("D", null);

	
	graph.addEdge("A", "B");
	graph.addEdge("A", "C");
	graph.addEdge("B", "C");
	graph.addEdge("C", "D");
	graph.displayAdjacencyList();

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
