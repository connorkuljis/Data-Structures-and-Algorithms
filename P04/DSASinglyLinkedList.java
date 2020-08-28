/* ***************************************************************************
 * NAME: DSASinglyLinkedList.java
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms
 * PURPOSE: 
 * COMMENT:
 * DATE: 2020-08-28
 * **************************************************************************/

public class DSASinglyLinkedList
{
    DSAListNode head;

    public DSALinkedList()
    {
        head = null;
    }

    public void insertFirst(Object newValue)
    {
        DSAListNode newNode = new DSAListNode(newValue);
        if (isEmpty())
        {
            head = newNode;
        }
        else
        {
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
        }
        else
        {
            DSAListNode curNode = head;
            while (curNode.getNext() != null)
            {
                curNode = curNode.getNext();
            }
            curNode.setNext(newNode);
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
            DSAListNode curNode = head;
            while (curNode.getNext() != null) // traversing to the last node
            { 
                curNode = curNode.getNext();
            }
            nodeValue = curNode.getValue();
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
            prevNode = null;
            curNode = head;
            while (curNode.getNext() != null)
            {
                prevNode = curNode;
                curNode = curNode.getNext();
            }
            prevNode.setNext(null);
            nodeValue = curNode.getValue();
        }
        return nodeValue;
    }
}
