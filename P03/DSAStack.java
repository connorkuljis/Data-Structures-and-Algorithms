/* ***************************************************************************
 * NAME: DSAStack.java
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: COMP1002 - Data Structures and Algorithms
 * PURPOSE: Class file of a stack to be used in the unit DSA
 * COMMENT: 
 * DATE: 2020-08-21
 * **************************************************************************/
import java.util.*;

public class DSAStack
{
    // class constants 
    private static int DEFAULT_CAPACITY = 100;

    // class fields
    private Object[] stack;
    private int count;

    // default constructor
    public DSAStack()
    {
        stack = new Object[DEFAULT_CAPACITY];
        count = 0;
    }

    // alternate constructor
    public DSAStack(int maxCapacity)
    {
        stack = new Object[maxCapacity];
        count = 0;
    }

    // accessors
    public int getCount()
    {
        return count;
    }

    public boolean isEmpty()
    {
        boolean empty = false;
        if (count == 0)
        {
            empty = true;
        }
        return empty;
    }

    public boolean isFull()
    {
        boolean full = false;
        if (count == stack.length)
        {
            full = true;
        }
        return full;
    }
    
    // mutator
    public void push(Object inObj)
    {
        if (isFull())
        {
            throw new IllegalArgumentException("Cannot push " + inObj + " because the stack is full.");
        }
        else
        {
            stack[count] = inObj;
            count++;
        }
    }

    public Object pop()
    {
        Object topObj = top();
        count--;
        return topObj;
    }

    public Object top()
    {
        Object topObj = null;
        if (isEmpty())
        {
            throw new IllegalArgumentException("Error. Stack is empty.");
        }
        else
        {
            topObj = stack[count - 1];
        }
        return topObj;
    }
    
    public void display()
    {
	System.out.print("["); 
	for (int i = 0; i < count; i++)
	{
	    if (i == count - 1)
	    {
		System.out.print(stack[i]); 

	    }
	    else
	    {
		System.out.print(stack[i] + ", "); 
	    }
	}
	System.out.println("]"); 
    }
}
