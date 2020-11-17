/**
 * DSA Final Assessment Question 5 - FA_GraphEdge.java
 *
 * Name : Connor Kuljis	
 * ID   : 19459138
 *
 **/

public class FA_GraphEdge
{
    private FA_GraphVertex from;
    private FA_GraphVertex to;
    private String label;
    private Object value;

    public FA_GraphEdge(FA_GraphVertex fromVertex, FA_GraphVertex toVertex,
	    String inLabel, Object inValue)
    {
	from = fromVertex;
	to = toVertex;
	label = inLabel;
	value = inValue;
    }

    public FA_GraphVertex getFrom()
    {
	return from;
    }

    public FA_GraphVertex getTo()
    {
	return to;
    }

    public Object getValue()
    {
	return value;
    }

    public String toString()
    {
	return label;
    }

}
