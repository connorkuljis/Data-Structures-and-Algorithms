
import java.util.*;

public abstract class DSAQueue
{
    // class constants 
    protected static int DEFAULT_CAPACITY = 100;

    // class fields
    protected Object[] queue;
    protected int nItems = 0;
    protected int front = 0;
    protected int rear;

    // mutator
    protected abstract void insert(Object inObj);
    protected abstract Object remove();

    protected abstract boolean isEmpty();
    // return (nItems == 0);

    protected abstract boolean isFull();
    // return (nItems == queue.length);

    public Object peek()
    {
	return queue[front];
    }

    public int size()
    {
	return nItems;
    }
}
