/* ***************************************************************************
 * NAME: DSAMatrixGraph
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE: this is a basic implementation of a graph using a 2d array as for an adjacency matrix.
 * COMMENT:
 * DATE: 2020-
 * **************************************************************************/

public class DSAMatrixGraph
{
    private int[][] adjMat;
    DSALinkedList labels;

    public DSAMatrixGraph()
    {
        labels = new DSALinkedList();
        adjMat = null;
    }

    public DSAMatrixGraph(int numVerticies)
    {
        labels = new DSALinkedList();
        adjMat = new int[numVerticies][numVerticies];

        // fill array with zeros
        for (int i = 0; i < numVerticies; i++)
        {
            for (int j = 0; j < numVerticies; j++)
            {
                adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(char label)
    {
        labels.insertLast(label);
    }

    public void addEdge(int start, int end)
    {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public boolean hasVertex(char label)
    {
        boolean found = false;
        for (Object e : labels)
        {
            DSAListNode node = (DSAListNode) e;
            if ((char)node.getValue() == label)
            {
                found = true;
            } 
        }
        return found;
    }

    public int getVertexCount()
    {
        int vertexCount = 0;
        for (Object e : labels)
        {
            vertexCount++;
        }
        return vertexCount;
    }

    public int getEdgeCount()
    {
        int edgeCount = 0;
        for (int i = 0; i < adjMat.length; i++)
        {
            for (int j = 0; j < adjMat[0].length; j++)
            {
                edgeCount += adjMat[i][j];
            }
        }
        return edgeCount / 2;
    }

    public boolean isAdjancent(int vertex1, int vertex2) // alternatively take the char labels
    {
        boolean adjacent = false;
        if (adjMat[vertex1][vertex2] == 1)
        {
            adjacent = true;
        }
        return adjacent;
    }

    public DSALinkedList getAdjacent(int vertex)
    {
        DSALinkedList adjacent = new DSALinkedList();
        for (int j = 0; j < adjMat.length; j++)
        {
            if (adjMat[vertex][j] == 1)
            {
                adjacent.insertLast(adjMat[vertex][j]);
            }
        }
        return adjacent;
    }

    public void displayAsMatrix()
    {
        for (int i = 0; i < adjMat.length; i++)
        {
            for (int j = 0; j < adjMat[0].length; j++)
            {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
