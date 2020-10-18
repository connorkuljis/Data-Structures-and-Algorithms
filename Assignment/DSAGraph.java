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

    public DSAGraph()
    {
        verticies = new DSALinkedList();
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
    public void addEdge(String vertex1, String vertex2)
    {
        if (hasVertex(vertex1) && hasVertex(vertex2)) // if the verticies exist in the graph
        {
	    // first find the two verticies that match the label
	    DSAGraphVertex v1 = null; // storing the first
	    DSAGraphVertex v2 = null; // storing the second

	    // iterate through the list of verticies
            for (Object e : verticies) 
            {
		// need to get their labels
                DSAListNode currNode = (DSAListNode) e;
                DSAGraphVertex currVertex = (DSAGraphVertex) currNode.getValue();
                String label = currVertex.getLabel();

                if (label.equals(vertex1)) // we have found our first label
                {
		    v1 = currVertex;
                }
                else if (label.equals(vertex2)) // we have found our second label
                {
		    v2 = currVertex;
                }
            }

	    // undirected graph so we can add to both sides
	    v1.getAdjacent().insertLast(v2);
	    v2.getAdjacent().insertLast(v1);
        }
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

    // public int getEdgeCount()

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
        for (Object e : vertex.getAdjacent())
        {
            //if (e.getLabel.equals(inString))
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

    public void display()
    {
        for (Object e : verticies)
        {
            DSAListNode node = (DSAListNode) e;
            System.out.println(node.getValue());
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

            DSALinkedList adjList = vertex.getAdjacent();
            for (Object g : adjList)
            {
		DSAGraphVertex currVertex = (DSAGraphVertex) g;
                System.out.print(currVertex.getLabel() + " ");
		// System.out.println(currVertex); 
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

	    for (Object e : curr.getAdjacent())
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

	    for (Object e : curr.getAdjacent())
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
