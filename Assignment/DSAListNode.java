/* ***************************************************************************
 * NAME: DSAListNode.java
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms
 * PURPOSE: 
 * COMMENT:
 * DATE: 2020-08-28
 * **************************************************************************/

public class DSAListNode
{
    private Object data;
    private DSAListNode next;
    private DSAListNode previous;

    public DSAListNode(Object inObj)
    {
        data = inObj;
    }

    public Object getValue()
    {
        return data;
    }

    public void setValue(Object inValue)
    {
        data = inValue;
    }

    public DSAListNode getNext()
    {
        return next;
    }

    public void setNext(DSAListNode inNext)
    {
        next = inNext;
    }

    public DSAListNode getPrevious()
    {
        return previous;
    }

    public void setPrevious(DSAListNode inPrevious)
    {
        previous = inPrevious;
    }
}
