/**
 * DSA Final Assessment Question 3 - FA_MaxHeap.java
 *
 * Name : Connor Kuljis
 * ID   : 1945913
 *
 **/
 
public class FA_MaxHeap
{

	public class FA_HeapEntry
	{
	    private int priority;
	    private Object value;

	    public FA_HeapEntry(int priority, Object value)
	    {
		    this.priority = priority;
		    this.value = value;
	    }

	    public int getPriority()
	    {
		    return priority;
	    }

	    public Object getValue()
	    {
		    return value;
	    }
	}

	private FA_HeapEntry[] heap;
	private int count;
	private int MAXSIZE = 10;
	
	
	public FA_MaxHeap()
	{
		heap = new FA_HeapEntry[MAXSIZE];
		count = 0;	
	}


	public void add(int priority, Object value) throws PracExamException
	{
		FA_HeapEntry entry = new FA_HeapEntry(priority, value);

		if (count >= MAXSIZE)
		{
		    throw new PracExamException("Heap is full!");
		}

		heap[count] = entry;
		count++;
		trickleUp(count-1);
	}

	// edit: wrapped in try catch
	public Object remove() throws PracExamException
	{
		Object retValue = null; // init with temp
		try
		{
		    FA_HeapEntry entry = heap[0]; // may encounter null pointer error here
		    retValue = entry.getValue();
		    heap[0] = heap[count-1];
		    heap[count-1] = null;
		    count--;
		    trickleDown(0);
		}
		catch (Exception e)
		{
		    throw new PracExamException("Trying to remove from an empty heap!"); // throwing custom exception
		}

		return retValue;
	}

	private void trickleDown(int index)
	{
	   int leftIdx = index * 2 + 1;
	   int rightIdx = leftIdx + 1;
	   int largeIdx;
	   FA_HeapEntry temp;

	   if (leftIdx < count)
		{
		largeIdx = leftIdx;			
		if (rightIdx < count)
		{
		   if (heap[leftIdx].getPriority() < heap[rightIdx].getPriority())
			{
				largeIdx = rightIdx;
			}
		}
		if (heap[largeIdx].getPriority() > heap[index].getPriority())
		{
              	temp = heap[largeIdx];
              	heap[largeIdx] = heap[index];
              	heap[index] = temp;
			trickleDown(largeIdx);
		}	
	   }
	}
	
	private void trickleUp(int index)
	{
		int parentIndex;
		FA_HeapEntry temp;

		parentIndex = (index-1)/2;

		if (index > 0 )
		{
			if (heap[index].getPriority() > heap[parentIndex].getPriority())
			{
				temp = heap[parentIndex];
				heap[parentIndex] = heap[index];
				heap[index] = temp;
				trickleUp(parentIndex);
			}
		}
		
	}

	/**
	 * ADDITIONAL METHODS
	 * */
	public void printContents()
	{
	    System.out.println("***DISPLAYING CONTENTS***"); 
	    for(int i = 0; i < count; i++)
	    {
		System.out.println("[priority: " + heap[i].getPriority() + ", value: " + heap[i].getValue() + "]"); 
	    }

	}

	public void heapify() // this method will convert the array to a bst format
	{
	    int nonLeafIdx = (count / 2 ) - 1;
	    for (int i = nonLeafIdx; i >= 0; i--)
	    {
		trickleDown(i);
	    }
	}

}
