/* ***************************************************************************
 * NAME: DASHeapEntry
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE: Class Template for an instance if a heap entry
 * COMMENT:
 * DATE: 2020-10-13
 * **************************************************************************/
public class DSAHeapEntry
{
    private double priority;
    private Object value;

    public DSAHeapEntry(double inPriority, Object inValue)
    {
	priority = inPriority;
	value = inValue;
    }

    public double getPriority()
    {
	return priority;
    }

    public Object getValue()
    {
	return value;
    }

}
