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

    public DSAGraph()
    {
        verticies = new DSALinkedList();
	edges = new DSALinkedList();
    }

    public void addVertex(String label, Object value)
    {
        DSAGraphVertex vertex;
        DSAListNode node;
        
        vertex = new DSAGraphVertex(label, value);
        node = new DSAListNode(vertex);

        verticies.insertLast(node);
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
	
	fromVertex.addEdge(edge); // directed graph so just add the path 'from -> to'
			  // from's adjacency list will include to,
	                  // but to's adjacency list will not include from/
	edges.insertLast(edge);
    }

    public DSAGraphVertex getVertex(String inLabel) throws IllegalArgumentException
    {
	DSAGraphVertex vertex = null;

	for (Object e : verticies) 
	{
	    // casting each object in the verticies list to a vertex
	    DSAListNode currNode = (DSAListNode) e;
	    DSAGraphVertex currVertex = (DSAGraphVertex) currNode.getValue();

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

    public boolean hasVertex(String label)
    {
        boolean found;
        found = false;
        for (Object e : verticies)
        {
            DSAListNode node = (DSAListNode) e;
            DSAGraphVertex vertex = (DSAGraphVertex) node.getValue();
            if (label.equals(vertex.getLabel()))
            {
                found = true;
            }
        }
        return found;
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

    public boolean isAdjancent(String vertex1, String vertex2) // alternatively take the char labels
    {
        boolean adjacent = false;
        int count = 0;
        if (hasVertex(vertex1) && hasVertex(vertex2)) // if the verticies exist in the graph
        {
            // iterate through the verticies
            for (Object e : verticies) // May be slow due to iterating though the linked list
            {
                DSAGraphVertex vertex = (DSAGraphVertex) e;
                if (vertex.getLabel().equals(vertex1))     
                {
                    // check if the other vertex exists in the current vertex adj
                    if (hasAdjacent(vertex, vertex1))
                    {
                        count++;
                    }
                }
                if (vertex.getLabel().equals(vertex2))         // is the inverse of line 33
                {
                    if (hasAdjacent(vertex, vertex2))
                    {
                        count++;
                    }
                }
                else 
                {
                    throw new IllegalArgumentException("Error trying to find adjacent verticies");
                }
            }
        }
        if (count == 2) // this means that the two adjacent verticies are bidirectional
        {
            adjacent = true;
        }
        return adjacent;
    }

    // returns true if the vertex labeled inString exists within the vertex's adjacency list
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

    public void displayVertices()
    {
        for (Object e : verticies)
        {
            DSAListNode node = (DSAListNode) e;
	    DSAGraphVertex vertex = (DSAGraphVertex) node.getValue();
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
            DSAListNode node = (DSAListNode) e;
            DSAGraphVertex vertex = (DSAGraphVertex) node.getValue();
            System.out.print(vertex.getLabel() + " | ");

            DSALinkedList adjList = vertex.getAdjacencyList();
            for (Object g : adjList)
            {
		// DSAGraphVertex currVertex = (DSAGraphVertex) g;
                // System.out.print(currVertex.getLabel() + " ");
		// System.out.println(currVertex); 
		System.out.print(g + " "); 
            }
            System.out.println("");
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
		System.out.println(e); 
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
