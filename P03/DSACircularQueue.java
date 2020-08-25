
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
	    System.out.println("Queue is full '" + inObj + "' has not been entered"); 
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
	    System.out.println("Queue is empty, object cannot be removed.");
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
	return (((rear + 1) == front) || ((front + queue.length - 1) == rear));
    }

    @Override
    protected boolean isFull()
    {
	return (((rear + 2) == front) || ((front + queue.length - 2) == rear));
    }
}
