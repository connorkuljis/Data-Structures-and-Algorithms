
import java.util.*;

public class DSACircularQueue
{
    // class constants 
    private static int DEFAULT_CAPACITY = 100;

    // class fields
    private Object[] queue;
    private int count = 0;
    private int front -1;
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

    public void enqueue(Object inObj)
    {
	if (!isFull()) // if our queue is full, just fall through
	{
	    if (isEmpty()) // if the queue is empty, start at indexes of 0
	    {
		front = 0;
		rear = 0;
	    }
	    else // if the queue already has elements, increase the rear pointer
	    {
		rear++;
	    }
	    queue[rear] = inObj; // enter element in the new cell.
	}
    }

    public void dequeue(Object inObj)
    {
	if (!isEmpty())
	{
	    if (front == rear)
	    {
		front = -1;
		rear = -1;
	    }
	    else 
	    {
		front++;
	    }
	}
    }

    public boolean isFull()
    {
	boolean full = false;

	int maxCapacity = queue.length - 1;
	if (rear == maxCapacity)
	{
	    full = true;
	}
	return full;
    }

    public boolean isEmpty()
    {
	boolean valid = false;
	if ((front == -1) && (rear == -1)) // we set our 'pointers' (front and
	                                   // rear) to rest at index -1
	{
	    valid = true;
	}
	return valid;
    }

}
