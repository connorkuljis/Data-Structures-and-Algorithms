/* ***************************************************************************
 * NAME: DSAGraphNode
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE: Our Class for nodes/verticies for graphs
 * COMMENT:
 * DATE: 2020-09-27`
 * **************************************************************************/
public class DSAGraphVertex 
{
    public String label;
    public Object value; // optional?
    public DSALinkedList adjacencyList;
    public boolean wasVisited;
    int inDegree;
    int outDegree;

    public DSAGraphVertex(String inLabel, Object inValue)
    {
        label = inLabel;
        value = inValue; 
        adjacencyList = new DSALinkedList();
        wasVisited = false;
	inDegree = 0;
	outDegree = 0;
    }

    public void addEdge(DSAGraphVertex inVertex)
    {
	adjacencyList.insertLast(inVertex);
	outDegree++;
    }

// ACCESSOR getLabel IMPORTS NONE EXPORTS label
    public String getLabel()
    {
        return label;
    }

// ACCESSOR getValue IMPORTS NONE EXPORTS value
    public Object getValue()
    {
        return value;
    }
    
    public void setValue(Object inValue)
    {
	value = inValue;
    }

// ACCESSOR getAdjacent IMPORTS NONE EXPORTS vertexList
    public DSALinkedList getAdjacencyList()
    {
	return adjacencyList;
    }

// [ACCESSOR getAdjacentE IMPORTS NONE EXPORTS edgeList]
// [MUTATOR addEdge IMPORTS edge/vertex EXPORTS NONE]
// MUTATOR setVisited IMPORTS NONE EXPORTS NONE //later
    public void setVisited()
    {
        wasVisited = true;
    }

// MUTATOR clearVisited IMPORTS NONE EXPORTS NONE
    public void clearVisited()
    {
        wasVisited = false;
    }

// ACCESSOR getVisited IMPORTS NONE EXPORTS Boolean
    public boolean getVisited()
    {
        return wasVisited;
    }

    public void incrementInDegree()
    {
	inDegree++;
    }

// ACCESSOR toString IMPORTS NONE EXPORTS string
    public String toString()
    {
        return label;
    }
}
