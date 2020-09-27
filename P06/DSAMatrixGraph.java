/* ***************************************************************************
 * NAME:
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE:
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
            if (label == (char)node.getValue())
            {
                found = true;
            } 
        }
        return found;
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