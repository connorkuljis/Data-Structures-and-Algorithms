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
    private int priority;
    private Object value;

    public DSAHeapEntry(int inPriority, Object inValue)
    {
	priority = inPriority;
	value = inValue;
    }

    public int getPriority()
    {
	return priority;
    }

    public int getValue()
    {
	return value;
    }

}
