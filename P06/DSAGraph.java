/* ***************************************************************************
 * NAME: DSAGraph
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE: DSA Graph using Adjacency List
 * COMMENT:
 * DATE: 2020-10-01
 * **************************************************************************/

public class DSAGraph
{
    DSALinkedList verticies; // List of Graph Nodes

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

    public void addEdge(String vertex1, String vertex2)
    {
        if (hasVertex(vertex1) && hasVertex(vertex2)) // if the verticies exist in the graph
        {
            for (Object e : verticies) // May be slow due to iterating though the linked list
            {
                DSAListNode node;
                DSAGraphVertex vertex;
                DSALinkedList adjList;
                String label;

                node = (DSAListNode) e;
                vertex = (DSAGraphVertex) node.getValue();

                label = vertex.getLabel();
                adjList = vertex.getAdjacent();

                if (label.equals(vertex1))
                {
                    adjList.insertLast(vertex2);
                }
                else if (label.equals(vertex2))
                {
                    adjList.insertLast(vertex1);
                }
                // error handling?
            }
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

    // public DSALinkedList getAdjacent(String vertex)

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
        for (Object e : verticies)
        {
            DSAListNode node = (DSAListNode) e;
            DSAGraphVertex vertex = (DSAGraphVertex) node.getValue();
            System.out.print(vertex.getLabel() + " | ");

            DSALinkedList adjList = vertex.getAdjacent();
            for (Object g : adjList)
            {
                System.out.print(g + " ");
            }
            System.out.println("");
        }
    }
}
