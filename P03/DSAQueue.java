
import java.util.*;

public class DSAQueue
{
    // class constants 
    private static DEFAULT_CAPACITY = 100;

    // class fields
    private Object[] queue;
    private int count;
    private int front;
    private int rear;

    // constructor
    public DSAQueue()
    {
        queue = new Object[DEFAULT_CAPACITY];
        count = 0;
        front = 0;
        rear = -1;
    }

    // alternate constructor
    public DSAQueue(int maxCapacity)
    {
        queue = new Object[maxCapacity];
        count = 0;
        front = 0;
        rear = -1;
    }

    // mutator
    public void insert(Object inObj)
    {
        if (rear == queue.length - 1)
        {
            rear = - 1;
            queue[++rear] = inObj;
            count++;
        }
    }

    // accessor
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
        // return (count == 0);
    }

    public boolean isFull()
    {
        boolean full = false;
        if (count == queue.length)
        {
            full = true;
        }
        return full;
    }

    // mutator
    public 
    public abstract void enqueue (Object inObj);

    public abstract void dequeue (Object inObj);

    public abstract Object peek();
        


}
