/* ***************************************************************************
 * NAME: DSAGraphEdge
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE: DSA Graph Edge
 * COMMENT:
 * DATE: 2020-10-25
 * **************************************************************************/

public class DSAGraphEdge
{
    private DSAGraphVertex from;
    private DSAGraphVertex to;
    private String label;
    Object value;

    public DSAGraphEdge(DSAGraphVertex fromVertex, DSAGraphVertex toVertex, 
	    String inLabel, Object inValue)
    {
	from = fromVertex;
	to = toVertex;
	label = inLabel;
	value = inValue;
    }

    public void setValue(Object inValue)
    {
	value = inValue;
    }

    public String getLabel()
    {
	return label;
    }

    public Object getValue()
    {
	return value;
    }

    public DSAGraphVertex getFrom()
    {
	return from;
    }

    public DSAGraphVertex getTo()
    {
	return to;
    }

    public String toString()
    {
	return label;
    }
}


