/* ***************************************************************************
 * NAME: DSAStack.java
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: COMP1002 - Data Structures and Algorithms
 * PURPOSE: Class file of a stack to be used in the unit DSA
 * COMMENT: - changed the array to a list
 *          - removed isFull, count, MAX_CAPACITY and alternate constructor
 * DATE: 2020-09-11
 *
 * REFERENCES: This is modified code, previously submitted in Practial 3
 *             - Stack and Queues.
 *
 *             Implementation follows structure of psuedocode from Lecture 3 -
 *             stacks and queues
 * **************************************************************************/
import java.util.*;

public class DSAStack implements Iterable
{
    // class fields
    private DSALinkedList list;

    // default constructor
    public DSAStack()
    {
	list = new DSALinkedList();
    }

    public Iterator iterator()
    {
	return list.iterator();
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    // mutator
    public void push(Object inObj)
    {
	list.insertFirst(inObj);
    }

    public Object pop()
    {
	Object returnVar;

	returnVar = list.peekFirst();
	list.removeFirst();

	return returnVar;
    }

    public Object top()
    {
        return list.peekLast();
    }
    
    public void display()
    {
	for (Object e : list)
	{
	    System.out.println(e); 
	}
    }
}
