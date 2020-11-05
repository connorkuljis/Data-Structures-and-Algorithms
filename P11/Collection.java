/* ***************************************************************************
 * NAME: Collection.java
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

import java.util.*;

public interface Collection<E> extends Iterable<E>
{
    // insert
    boolean add(E e);
    boolean addAll(Collection<? extends E> c);

    // remove
    boolean remove(Object o);
    boolean removeAll(Collection<?> c);
    void clear();

    // state
    int size();
    boolean isEmpty();

    // contains
    boolean contains(Object o);
    boolean containsAll(Collection<?> c);

    // iterator
    Iterator<E> iterator();

    // Array
    Object[] toArray();
    <T> T[] toArray(T[] a);








}
