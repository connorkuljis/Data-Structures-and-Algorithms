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
    public class DSAHeapEntry
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

    private int getLeftChildIdx(int parentIdx) { return 2 * parentIdx + 1; }
    private int getRightChildIdx(int parentIdx) { return 2 * parentIdx + 2; }
    private int getParentIdx(int childIdx) { return (childIdx - 1) / 2; }

    private boolean hasLeftChild(int idx) { return getLeftChildIdx(idx) < count; }
    private boolean hasRightChild(int idx) { return getRightChildIdx(idx) < count; }
    private boolean hasParent(int idx) { return getParentIdx(idx) >= 0; }

    public DSAHeapEntry[] getHeap() { return heap; }

    public void add(int inPriority, Object inObject)
    {
	DSAHeapEntry newItem = new DSAHeapEntry(inPriority, inObject);
	int startAtEnd = count;

	checkCapacity();
	heap[startAtEnd] = newItem;
	count++;

	trickleUpRecur(startAtEnd);
    }

    public DSAHeapEntry remove()
    {
	int end = count - 1;
	int start = 0;
	
	DSAHeapEntry root = heap[start];

	heap[start] = heap[end];
	heap[end] = null;
	count--;

	trickleDownRecur(start);

	return root;

    }

    private void trickleUpRecur(int curIdx)
    {
	int parentIdx = getParentIdx(curIdx);
	if (curIdx > 0)
	{
	    if (heap[curIdx].priority > heap[parentIdx].priority)
	    {
		// swap
		swap(parentIdx, curIdx);
		trickleUpRecur(parentIdx);
	    }
	}
    }

    private void swap (int sourceIdx, int withIdx)
    {
	DSAHeapEntry temp = heap[sourceIdx];
	heap[sourceIdx] = heap[withIdx];
	heap[withIdx] = temp;
    }

    private void trickleDownRecur(int curIdx)
    {
	int leftChildIdx = getLeftChildIdx(curIdx);
	int rightChildIdx = getRightChildIdx(curIdx);
	int largeIdx;

	if (leftChildIdx < count)
	{
	    largeIdx = leftChildIdx;
	    if (rightChildIdx < count)
	    {
		if (heap[leftChildIdx].priority < heap[rightChildIdx].priority)
		{
		    largeIdx = rightChildIdx;
		}
	    }
	    if (heap[largeIdx].priority > heap[curIdx].priority)
	    {
		swap(largeIdx, curIdx);
		trickleDownRecur(largeIdx);
	    }
	}
    }

    private void checkCapacity()
    {
	if (count == capacity) // if we have filled the array
	{
	    capacity = capacity * 2; // double the capacity
	    DSAHeapEntry[] newHeap = new DSAHeapEntry[capacity]; 
	    for (int i = 0; i < heap.length; i++) // fill the new array
	    {
		newHeap[i] = heap[i];
	    }
	    heap = newHeap; // set the heap array to the new array
	}
    }

    public void heapify()
    {
	int nonLeafIdx = (count / 2 ) - 1;
	for (int i = nonLeafIdx; i > 0; i--)
	{
	    trickleDownRecur(i);
	}
    }

    public void heapSort()
    {
	heapify();

	for (int i = count - 1; i > 1; i--)
	{
	    swap(0, i);
	    trickleDownRecur(0);
	}
    }

    public void display()
    {
	System.out.print("[ "); 
	for (int i = 0; i < count; i++)
	{
	    System.out.print(heap[i].priority + ", "); 
	}
	System.out.print("] "); 
	System.out.println(""); 
    }




}
