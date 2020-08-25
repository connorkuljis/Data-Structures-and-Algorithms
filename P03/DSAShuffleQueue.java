
import java.util.*;

public class DSAShuffleQueue
{
    // class constants 
    private static int DEFAULT_CAPACITY = 100;

    // class fields
    private Object[] queue;
    private int nItems = 0;
    private int front = 0;
    private int rear = 0; // will be changed in constructors to max size

    // constructor
    public DSAShuffleQueue()
    {
        queue = new Object[DEFAULT_CAPACITY];
    }

    // alternate constructor
    public DSAShuffleQueue(int maxCapacity)
    {
        queue = new Object[maxCapacity];
    }

    public void insert(Object inObj)
    {
	if (isFull())
	{
	    System.out.println("Queue is full"); 
	}
	else
	{
	    queue[rear] = inObj;
	    rear++;
	    nItems++;
	}
    }

    public Object remove()
    {
	Object temp = null;
	if (isEmpty())
	{
	    System.out.println("Queue is empty"); 
	}
	else
	{
	    temp = queue[0];
	    for (int i = 0; i < (rear - 1); i++)
	    {
		queue[i] = queue[i+1];
	    }
	    rear--;
	    nItems--;
	}
	return temp;
    }

    public Object peek()
    {
	return queue[0];
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

    public void printIt()
    {
	System.out.print("["); 
	for(int i = 0; i < nItems; i++)
	{
	    System.out.print(queue[i] + ", "); 
	}
	System.out.print("]\n"); 

    }

}
