/* ***************************************************************************
 * NAME: Queue.java
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE:
 * COMMENT:
 * DATE: 2020-11-5
 *
 * REFERENCES - https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html#contains-java.lang.Object-
 * 		Lecture 11 - DSA In Practice. Curtin University, accessed 2020-11-05
 *
 *
 * **************************************************************************/

/* ***************************************************************************
 * ADD: Inserts the specified element into this queue if it is possible to do so 
 * 	immediately without violating capacity restrictions, returning true 
 * 	upon success and throwing an IllegalStateException if no space is currently available.
 *
 * ELEMENT: Retrieves, but does not remove, the head of this queue.
 *
 * **************************************************************************/
public interface Queue<E> extends Collection<E>
{
    boolean add(E e);
    E element();
    boolean offer(E e);
    E peek();
    E poll();
    E remove();
}
