/* ***************************************************************************
 * NAME: DSAGraph
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE: DSA Graph using Adjacency List
 * COMMENT:
 * DATE: 2020-10-01
 * helpful video ->
 * https://www.youtube.com/watch?v=TIbUeeksXcI 
 * **************************************************************************/

public class DSAGraph
{
    private DSALinkedList verticies; // List of Graph Nodes
    private DSALinkedList edges;     // List of Edge Objects

    // default constructor
    public DSAGraph()
    {
        verticies = new DSALinkedList();
	edges = new DSALinkedList();
    }

    /* ************************************************************************
     * NAME   : addVertex
     * IMPORTS: label (String), value (Object)
     * EXPORTS: none
     * PURPOSE: Add a new node/vertex to the graph.
     * ASSERTION: Duplicate nodes are not allowed in the graph
     * ***********************************************************************/
    public void addVertex(String label, Object value)
    {
        DSAGraphVertex vertex;

	if(!hasVertex(label))
	{
	    vertex = new DSAGraphVertex(label, value);

	    verticies.insertLast(vertex);
	}
    }

    /* to add an edge between two verticies, we are given their labels */
    public void addEdge(String fromLabel, String toLabel, String edgeLabel, Object value)
    {
	DSAGraphVertex fromVertex = null;
	DSAGraphVertex toVertex = null;
	try
	{
	    fromVertex = getVertex(fromLabel);
	    toVertex = getVertex(toLabel);
	}
	catch (Exception e)
	{
	    e.getMessage();
	}

	DSAGraphEdge edge = new DSAGraphEdge(fromVertex, toVertex, edgeLabel, value);
	
	fromVertex.addEdge(toVertex); // directed graph so just add the path 'from -> to'
			  // from's adjacency list will include to,
	                  // but to's adjacency list will not include from/
	toVertex.incrementInDegree();

	edges.insertLast(edge);
    }

    public boolean hasVertex(String label)
    {
        boolean found;
        found = false;

	try
	{
	    getVertex(label);
	    found = true;
	}
	catch (Exception e)
	{
	    found = false;
	}

        return found;
    }

    public DSAGraphVertex getVertex(String inLabel) throws IllegalArgumentException
    {
	DSAGraphVertex vertex = null;

	for (Object e : verticies) 
	{
	    // casting each object in the verticies list to a vertex
	    DSAGraphVertex currVertex = (DSAGraphVertex) e;

	    // get the label
	    String curLabel = currVertex.getLabel();

	    if (curLabel.equals(inLabel)) // we have found our vertex
	    {
		vertex = currVertex;
	    }
	}
	// exception handling will throw error if the vertex does not exist
	if (vertex == null)
	{
	    throw new IllegalArgumentException("Cannot add edge (" + inLabel + 
		    "). Reason, Vertex (" + inLabel + ") does not exist");
	}

	return vertex;
    }


    public int getVertexCount()
    {
        int vertexCount = 0;
        for (Object e : verticies)
        {
            vertexCount++;
        }
        return vertexCount;
    }

    public int getEdgeCount()
    {
	int edgeCount = 0;
	for (Object e : edges)
	{
	    edgeCount++;
	}
	return edgeCount;
    }

    public boolean isAdjancent(String search, String toFind) // alternatively take the char labels
    {
        boolean adjacent = false;
	DSAGraphVertex from = null;
	DSAGraphVertex find = null;
	try
	{
	    from = getVertex(search);
	}
	catch (Exception e)
	{
	    System.out.println("Cannot find vertex " + search + " in the graph"); 
	}

	for (Object e : from.getAdjacencyList())
	{
	    DSAGraphVertex vertex = (DSAGraphVertex) e;
	    if (vertex.getLabel().equals(toFind))
	    {
		adjacent = true;
	    }
	}
        return adjacent;
    }

    private boolean hasAdjacent(DSAGraphVertex vertex, String inString)
    {
        boolean hasAdjacent = false;
        for (Object e : vertex.getAdjacencyList())
        {
	    DSAListNode node = (DSAListNode) e;
	    DSAGraphVertex checkVertex = (DSAGraphVertex) node.getValue();
	    if(checkVertex.getLabel().equals(inString))
            {
                hasAdjacent = true;
            }
        }
        return hasAdjacent;
    }

    public boolean isEmpty()
    {
	boolean empty;
	empty = false;

	if (verticies.isEmpty())
	{
	    empty = true;
	}
	return empty;
    }

    public void displayVerticies()
    {
        for (Object e : verticies)
        {
	    DSAGraphVertex vertex = (DSAGraphVertex) e;
            System.out.println(vertex.getLabel());
        }
    }

    public void displayEdges()
    {
        for (Object e : edges)
        {
	    System.out.println(e); 
        }
    }

    public void displayAdjacencyList()
    {
	System.out.println("Displaying Adjacency List:"); 
        for (Object e : verticies)
        {
            DSAGraphVertex vertex = (DSAGraphVertex) e;

            DSALinkedList adjList = vertex.getAdjacencyList();
	    if (!adjList.isEmpty())
	    {
		System.out.print(vertex.getLabel() + " | ");
		for (Object g : adjList)
		{
		    DSAGraphVertex currVertex = (DSAGraphVertex) g;
		    System.out.print(currVertex.getLabel() + " ");
		    // System.out.println(currVertex); 
		    // System.out.print(g + " "); 
		}
		System.out.println("");
	    }
        }
    }

    public DSAQueue depthFirstSearch()
    {
	resetGraphVisited();
	DSAQueue traversalQueue = new DSAQueue();
	DSAStack stack = new DSAStack();

	DSAListNode front = (DSAListNode) verticies.peekFirst();
	DSAGraphVertex start = (DSAGraphVertex) front.getValue();

	start.setVisited();
	stack.push(start); // start the search 
	traversalQueue.insert(start);

	while (!stack.isEmpty())
	{
	    DSAGraphVertex curr = (DSAGraphVertex) stack.pop();
	    if (!curr.getVisited()) // if NOT Visisted eg: "new"
	    {
		curr.setVisited();
		traversalQueue.insert(curr);
	    }

	    for (Object e : curr.getAdjacencyList())
	    {
		DSAGraphVertex adjVertex = (DSAGraphVertex) e;
		if (!adjVertex.getVisited())
		{
		    stack.push(adjVertex);
		}
	    }
	}
	return traversalQueue;
    }

    public DSAQueue breadthFirstSearch()
    {
	resetGraphVisited();
	DSAQueue queue = new DSAQueue();
	DSAQueue traversalQueue = new DSAQueue();

	DSAListNode front = (DSAListNode) verticies.peekFirst();
	DSAGraphVertex start = (DSAGraphVertex) front.getValue();

	start.setVisited();
	
	queue.insert(start);
	traversalQueue.insert(start);

	while (!queue.isEmpty())
	{
	    DSAGraphVertex curr = (DSAGraphVertex) queue.remove();
	    if (!curr.getVisited())
	    {
		curr.setVisited();
		traversalQueue.insert(curr);
	    }

	    for (Object e : curr.getAdjacencyList())
	    {
		DSAGraphVertex adjVertex = (DSAGraphVertex) e;
		if (!adjVertex.getVisited())
		{
		    queue.insert(adjVertex);
		}
	    }
	}
	return traversalQueue;

    }

    private void resetGraphVisited()
    {
	for (Object e : verticies)
	{
	    DSAListNode node = (DSAListNode) e;
	    DSAGraphVertex vertex = (DSAGraphVertex) node.getValue();
	    vertex.clearVisited();
	}
    }
}
