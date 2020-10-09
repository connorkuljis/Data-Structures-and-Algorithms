/* ***************************************************************************
 * NAME:
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE:
 * COMMENT:
 * DATE: 2020-
 * **************************************************************************/

public class DSAHeap
{
    private class DSAHeapEntry
    {
	private int priority;
	private Object value;

	public DSAHeapEntry(int inPriority, Object inValue)
	{
	    priority = inPriority;
	    value = inValue;
	}
    }

    /** 
     *
     * */
    private DSAHeapEntry[] heap;
    private int count;
    private int capacity;

    public DSAHeap(int inSize)
    {
	heap = new DSAHeapEntry[inSize];
	count = 0;
	capacity = heap.length;
    }

    private int getLeftChildIdx(int parentIdx)
    {
	return 2 * parentIdx + 1;
    }

    private int getRightChildIdx(int parentIdx)
    {
	return 2 * parentIdx + 2;
    }

    private int getParentIdx(int childIdx)
    {
	return (childIdx - 2) / 2;
    }

    private boolean hasLeftChild(int idx)
    {
	return getLeftChildIdx(idx) < count;
    }

    private boolean hasRightChild(int idx)
    {
	return getRightChildIdx(idx) < count;
    }

    private boolean hasParent(int idx)
    {
	return getParentIdx(idx) >= 0;
    }




}
