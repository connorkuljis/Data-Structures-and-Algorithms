/* ***************************************************************************
 * NAME: DSAShuffleQueue
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: DSA
 * PURPOSE: Shuffle implementation of queue
 * COMMENT:
 * DATE: 2020-08-28
 * **************************************************************************/

import java.util.*;

public class DSAShuffleQueue extends DSAQueue
{
    // constructor
    public DSAShuffleQueue()
    {
        queue = new Object[DEFAULT_CAPACITY];
	rear = 0;
    }

    // alternate constructor
    public DSAShuffleQueue(int maxCapacity)
    {
        queue = new Object[maxCapacity];
	rear = 0;
    }

    @Override
    protected void insert(Object inObj)
    {
	if (isFull())
	{
	    throw new IllegalArgumentException("Error. Cannot insert object as the queue is full.");
	}
	else
	{
	    queue[rear] = inObj;
	    rear++;
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
