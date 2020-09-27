/* ***************************************************************************
 * NAME: DSAGraphNode
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE: Our Class for nodes/verticies for graphs
 * COMMENT:
 * DATE: 2020-09-27`
 * **************************************************************************/
public class DSAGraphNode 
{
    public char label;
    public Object value;
    public DSALinkedList adjList; // need to double check this
    public boolean wasVisited;

    public DSAGraphNode(char inLabel, Object inValue)
    {
        label = inLabel;
        value = inValue;
        adjList = null;
        wasVisited = false;
    }

// ACCESSOR getLabel IMPORTS NONE EXPORTS label
// ACCESSOR getValue IMPORTS NONE EXPORTS value
// ACCESSOR getAdjacent IMPORTS NONE EXPORTS vertexList
// [ACCESSOR getAdjacentE IMPORTS NONE EXPORTS edgeList]
// [MUTATOR addEdge IMPORTS edge/vertex EXPORTS NONE]
// MUTATOR setVisited IMPORTS NONE EXPORTS NONE //later
// MUTATOR clearVisited IMPORTS NONE EXPORTS NONE
// ACCESSOR getVisited IMPORTS NONE EXPORTS Boolean
// ACCESSOR toString IMPORTS NONE EXPORTS string


    
}
