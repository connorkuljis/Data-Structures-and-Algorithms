/* ***************************************************************************
 * NAME: DSAQueue.java
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE:
 * COMMENT:
 * DATE: 2020-09-11
 * **************************************************************************/

import java.util.*;

public class DSAQueue implements Iterable
{
    // class fields
    private DSALinkedList list;

    // mutator

    public DSAQueue()
    {
	list = new DSALinkedList();
    }

    public Iterator iterator()
    {
	return list.iterator();
    }

    public void insert(Object inObj)
    {
	list.insertLast(inObj);
    }

    public Object remove()
    {
	return list.removeFirst();
    }

    public boolean isEmpty()
    {
	return list.isEmpty();
    }

    public Object peek()
    {
	return list.peekFirst();
    }

    // public int size()
}
