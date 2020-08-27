/* ***************************************************************************
 * NAME: DSACircularQueue.java
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: DSA
 * PURPOSE: Circular queueu implementation
 * COMMENT:
 * DATE: 2020-08-28
 * **************************************************************************/
import java.util.*;

public class DSACircularQueue extends DSAQueue
{
    // constructor
    public DSACircularQueue()
    {
        queue = new Object[DEFAULT_CAPACITY];
	rear = -1;
    }

    // alternate constructor
    public DSACircularQueue(int maxCapacity)
    {
        queue = new Object[maxCapacity];
	rear = -1;
    }

    // mutator

    /* NAME: insert
     * IMPORTS: inObj (Object)
     * EXPORTS: none
     * PURPOSE: Inserts an object into the queue. We can insert an object fine 
     * as long as the rear pointer is not at the end. If the rear pointer is at the
     * end of the array we must wrap around (point at -1)                   */
    @Override
    protected void insert(Object inObj)
    {
	if (isFull())
	{
	    throw new IllegalArgumentException("Error. Cannot insert object as the queue is full.");
	}
	else
	{
	    if (rear == queue.length -1)
	    {
		rear = -1;
	    }
	    queue[++rear] = inObj; // increment rear and insert
	    nItems++;
	}
    }

    @Override
    protected Object remove() 
    {
	Object temp = null;
	if (isEmpty())
	{
	    throw new IllegalArgumentException("Error. Cannot remove object as the queue is empty.");
	}
	else
	{
	    temp = queue[front++];
	    if (front == queue.length)
	    {
		front = 0;
	    }
	    nItems--;
	}
	return temp;
    }

    @Override 
    protected boolean isEmpty()
    {
	return (nItems == 0);
    }

    @Override
    protected boolean isFull()
    {
	return (nItems == queue.length);
    }
}
