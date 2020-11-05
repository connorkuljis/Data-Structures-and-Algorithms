/* ***************************************************************************
 * NAME: Map.java
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

public interface Map<K,V>
{
    // Basic operations
     V put(K key, V value);
     V get(Object key);
     V remove(Object key);
     boolean containsKey(Object key);
     boolean containsValue(Object value);
     int size();
     boolean isEmpty();

     // Bulk operations
     void putAll(Map<? extends K, ? extends V> m);
     void clear();

     // Collection Views
     public Collection<V> values();
}

