/* ***************************************************************************
 * NAME: DSALinkedList.java
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms
 * PURPOSE: 
 * COMMENT:
 * DATE: 2020-08-28
 * **************************************************************************/
public class DSALinkedList
{
    DSAListNode head;
    DSAListNode tail;

    public DSALinkedList()
    {
        head = null;
	tail = null;
    }

    public void insertFirst(Object newValue)
    {
        DSAListNode newNode = new DSAListNode(newValue);
        if (isEmpty())
        {
            head = newNode;
	    tail = newNode;
        }
        else
        {
	    head.setPrevious(newNode);
	    newNode.setNext(head);
	    head = newNode;
        }
    }

    public void insertLast(Object newValue)
    {
        DSAListNode newNode = new DSAListNode(newValue);
        if (isEmpty())
        {
            head = newNode;
	    tail = newNode;
        }
        else
        {
	    tail.setNext(newNode);
	    tail = newNode;
        }
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public Object peekFirst()
    {
        Object nodeValue;
        if(isEmpty())
        {
            throw new IllegalArgumentException("Error. Cannot peek first, the linked list is empty.");
        }
        else
        {
            nodeValue = head.getValue();
        }
        return nodeValue;
    }

    public Object peekLast()
    {
        Object nodeValue;
        if (isEmpty())
        {
            throw new IllegalArgumentException("Error. Cannot peek last, the linked list is empty.");
        }
        else
        {
	    nodeValue = tail.getValue();
        }
        return nodeValue;
    }

    public Object removeFirst()
    {
        Object nodeValue;

        if (isEmpty())
        {
            throw new IllegalArgumentException("Error. Cannot remove last, the linked list is empty.");
        }
        else
        {
            nodeValue = head.getValue();
            head = head.getNext();
        }
        return nodeValue;
    }

    public Object removeLast()
    {
        Object nodeValue;
        DSAListNode curNode, prevNode;

        if (isEmpty())
        {
            throw new IllegalArgumentException("Error. Cannot remove last, the linked list is empty.");
        }
        else if (head.getNext() == null)
        {
            nodeValue = head.getValue();
            head = null;
        }
        else
        {
	    nodeValue = tail.getValue();
	    // make node doublely linked
        }
        return nodeValue;
    }
}
