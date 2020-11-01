/* ***************************************************************************
 * NAME: DSAGraph
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE: DSA Graph using Adjacency List
 * COMMENT:
 * DATE: 2020-10-01
 * helpful video ->
 * https://www.youtube.com/watch?v=TIbUeeksXcI 
 *
 * REFERENCES: This is modified code, previously submitted in Practial 6 
 *             - Graphs.
 *
 *             Implementation follows structure of psuedocode from Lecture 6 -
 *             Graphs
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
     * PURPOSE: Adds a new node/vertex to the graph.
     * ASSERTION: Duplicate nodes are skipped and not inserted into the graph
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

    /* ************************************************************************
     * NAME   : addEdge
     * IMPORTS: fromLabel (String), toLabel (String), edgeLabel (String),
     *          value (Object)
     * EXPORTS: none
     * PURPOSE: Adds a directed edge between two verticies.
     * ASSERTION: Its is a directed graph, so only insertion is only done on
     *            the source vertex
     * ***********************************************************************/
    public void addEdge(String fromLabel, String toLabel, String edgeLabel, 
	                Object value) throws IllegalArgumentException
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
	    throw new IllegalArgumentException(e);
	}

	DSAGraphEdge edge = new DSAGraphEdge(fromVertex, toVertex, edgeLabel, value);
	
	fromVertex.addEdge(toVertex); // directed graph so just add the path 'from -> to'
			  // from's adjacency list will include to,
	                  // but to's adjacency list will not include from/
	toVertex.incrementInDegree();

	edges.insertLast(edge);
    }

    public void addWeight(String inLabel, Object inValue)
    {
	try
	{
	    DSAGraphEdge edge = getEdge(inLabel);
	    edge.setValue(inValue);
	}
	catch (Exception e)
	{

	}
    }

    /* ************************************************************************
     * NAME   : hasVertex
     * IMPORTS: label (String)
     * EXPORTS: boolean
     * PURPOSE: returns true if the target vertex exists in the vertices list
     * ***********************************************************************/
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

    /* ************************************************************************
     * NAME   : getVertex
     * IMPORTS: inLabel (String)
     * EXPORTS: vertex (DSAGraphVertex)
     * PURPOSE: returns the vertex from the list
     * ASSERION: Throws error if the vertex does not exist
     * ***********************************************************************/
    public DSAGraphVertex getVertex(String inLabel) throws 
	                               IllegalArgumentException
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

    public DSAGraphEdge getEdge(String inLabel) throws 
	                               IllegalArgumentException
    {
	DSAGraphEdge edge = null;

	for (Object e : edges) 
	{
	    // casting each object in the verticies list to a vertex
	    DSAGraphEdge currEdge = (DSAGraphEdge) e;

	    // get the label
	    String curLabel = currEdge.getLabel();

	    if (curLabel.equals(inLabel)) // we have found our vertex
	    {
		edge = currEdge;
	    }
	}
	// exception handling will throw error if the vertex does not exist
	if (edge == null)
	{
	    throw new IllegalArgumentException("Cannot find edge (" + inLabel + 
		    ")");
	}

	return edge;
    }
    /* ************************************************************************
     * NAME   : getVertexCount
     * IMPORTS: none
     * EXPORTS: vertexCount (int)
     * PURPOSE: counts the number of verticies in the list
     * ***********************************************************************/
    public int getVertexCount()
    {
        int vertexCount = 0;
        for (Object e : verticies)
        {
            vertexCount++;
        }
        return vertexCount;
    }

    /* ************************************************************************
     * NAME   : getEdgeCount
     * IMPORTS: none
     * EXPORTS: edgeCount (int)
     * PURPOSE: counts the number of edges in the list
     * ***********************************************************************/
    public int getEdgeCount()
    {
	int edgeCount = 0;
	for (Object e : edges)
	{
	    edgeCount++;
	}
	return edgeCount;
    }

    /* ************************************************************************
     * NAME   : isAdjacent
     * IMPORTS: search (String), toFind (String)
     * EXPORTS: boolean
     * PURPOSE: given the names of two verticies, find if they are adjacent
     * ***********************************************************************/
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

    /* ************************************************************************
     * NAME   : hasAdjacent
     * IMPORTS: vertex (DSAGraphVertex), inString (String)
     * EXPORTS: boolean
     * PURPOSE: given a vertex object return true if there is an adjacent 
     *          vertex that matches the imported string
     * ***********************************************************************/
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

    /* ************************************************************************
     * NAME   : isEmpty
     * IMPORTS: none
     * EXPORTS: boolean
     * PURPOSE: return true if the graph is empty
     * ASSERTION: 'empty' means that there are no verticies, edge list can be 
     *            non-empty
     * ***********************************************************************/
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

    /* ************************************************************************
     * NAME   : displayVerticies
     * IMPORTS: none
     * EXPORTS: none
     * PURPOSE: print the verticies in the verticies list
     * ***********************************************************************/
    public void displayVerticies()
    {
        for (Object e : verticies)
        {
	    DSAGraphVertex vertex = (DSAGraphVertex) e;
            System.out.println(vertex.getLabel());
        }
    }

    /* ************************************************************************
     * NAME   : displayEdges
     * IMPORTS: none
     * EXPORTS: none
     * PURPOSE: print the edges in the edges list
     * ***********************************************************************/
    public void displayEdges()
    {
        for (Object e : edges)
        {
	    System.out.println(e); 
        }
    }

    /* ************************************************************************
     * NAME   : displayAdjacencyList
     * IMPORTS: none
     * EXPORTS: none
     * PURPOSE: print each vertex and its adjacency list in the verticies list
     * ***********************************************************************/
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

    /* ************************************************************************
     * NAME   : depthFirstSearch
     * IMPORTS: none
     * EXPORTS: traversalQueue(DSAQueue)
     * PURPOSE: depth first search algorithm
     * ***********************************************************************/
    public DSAQueue depthFirstSearch()
    {
	resetGraphVisited();
	DSAQueue traversalQueue = new DSAQueue();
	DSAStack stack = new DSAStack();

	DSAGraphVertex start = (DSAGraphVertex) verticies.peekFirst();

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

    /* ************************************************************************
     * NAME   : breadthFirstSearch
     * IMPORTS: none
     * EXPORTS: traversalQueue(DSAQueue)
     * PURPOSE: breadth first search algorithm
     * ***********************************************************************/
    public DSAQueue breadthFirstSearch()
    {
	resetGraphVisited();
	DSAQueue queue = new DSAQueue();
	DSAQueue traversalQueue = new DSAQueue();

	DSAGraphVertex start = (DSAGraphVertex) verticies.peekFirst();

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

    public void findAllPaths(String inSource, String inDest)
    {
	DSAGraphVertex source = getVertex(inSource);

	DSALinkedList list = new DSALinkedList();

	list.insertLast(source);

	System.out.println("POTENTIAL PATHS"); 
	findAllPathsRecur(source, inDest, list);

    }

    public void findAllPathsRecur(DSAGraphVertex source, String dest, DSALinkedList list)
    {
	if (source.getLabel().equals(dest))
	{
	    System.out.println(""); 
	}
	else
	{
	    source.setVisited();

	    for (Object e : source.getAdjacencyList())
	    {
		DSAGraphVertex currVertex = (DSAGraphVertex) e;
		if (!currVertex.getVisited())
		{
		    list.insertLast(currVertex);
		    System.out.print(currVertex + "->"); 
		    findAllPathsRecur(currVertex, dest, list);

		    list.remove(currVertex);
		}
	    }
	    source.clearVisited();
	}

    }
    
    public DSALinkedList getVerticies()
    {
	return verticies;
    }

    public DSALinkedList getEdges()
    {
	return edges;
    }

    public void removeVertex(String inString) 
    { 
	DSAGraphVertex toRemove = null;
	try
	{
	    toRemove = getVertex(inString);
	}
	catch(Exception e)
	{
	    System.out.println(e.getMessage()); 
	}

	verticies.remove(toRemove);
    }


    /* ************************************************************************
     * NAME   : resetGraphVisited
     * IMPORTS: none
     * EXPORTS: none
     * PURPOSE: refreshes the verticies to the "not-visited" state
     * ***********************************************************************/
    private void resetGraphVisited()
    {
	for (Object e : verticies)
	{
	    DSAGraphVertex vertex = (DSAGraphVertex) e;
	    vertex.clearVisited();
	}
    }
}
