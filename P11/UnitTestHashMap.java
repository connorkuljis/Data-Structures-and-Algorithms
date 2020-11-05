import java.util.HashMap;
/* ***************************************************************************
 * NAME: UnitTestHashMap.java
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
import java.util.Set;
import java.util.Collection;
import java.util.*;

public class UnitTestHashMap
{
    public static void main(String[] args)
    {
	System.out.println("### BUILT IN HASHMAP Test Harness"); 

	HashMap<String, Integer> table = new HashMap<String, Integer>();

	table.put("Apples", 10);
	table.put("Pears", 20);
	table.put("Bananas", 2);
	table.put("Grapes", 5);
	table.put("Oranges", 1);
	table.put("Assorted", 1);
	displayHashTableInfo(table);

	System.out.println("Removing key 'Apples'"); 
	table.remove("Apples");
	displayHashTableInfo(table);

	System.out.println("Removal of invalid key value"); 
	table.remove("Shoes");
	displayHashTableInfo(table);

    }

    private static void displayHashTableInfo(HashMap<String, Integer> table)
    {
	System.out.println(table.keySet());
	System.out.println(table.values()); 
	System.out.println(""); 
    }
}
