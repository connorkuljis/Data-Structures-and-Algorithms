
import java.util.*;

public class DSACircularQueue
{
    // class constants 
    private static int DEFAULT_CAPACITY = 100;

    // class fields
    private Object[] queue;
    private int nItems = 0;
    private int front = 0;
    private int rear = -1;

    // constructor
    public DSACircularQueue()
    {
        queue = new Object[DEFAULT_CAPACITY];
    }

    // alternate constructor
    public DSACircularQueue(int maxCapacity)
    {
        queue = new Object[maxCapacity];
    }

    // mutator

    /* NAME: insert
     * IMPORTS: inObj (Object)
     * EXPORTS: none
     * PURPOSE: Inserts an object into the queue. We can insert an object fine 
     * as long as the rear pointer is not at the end. If the rear pointer is at the
     * end of the array we must wrap around (point at -1)                   */
    public void insert(Object inObj)
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

    public Object remove()
    {
	Object temp = queue[front++];
	if (front == queue.length)
	{
	    front = 0;
	}
	nItems--;
	return temp;
    }

    public Object peek()
    {
	return queue[front];
    }

    public boolean isEmpty()
    {
	return (nItems == 0);
    }

    public boolean isFull()
    {
	return (nItems == queue.length);
    }


    public int size()
    {
	return nItems;
    }

}
