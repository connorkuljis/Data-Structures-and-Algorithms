/* ***************************************************************************
 * NAME: DSAQueueTestHarness.java
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: DSA
 * PURPOSE: test harness for DSA Queue (both types)
 * COMMENT:
 * DATE: 28-08-2020
 *
 * SELF-CITE NOTICE Contains code from prac 4 - LinkedList
 * **************************************************************************/
import java.util.*;

public class UnitTestDSAQueue
{
    public static void main(String[] args)
    {
	DSAQueue test1 = new DSAQueue();
	runThrough(test1);
    }

    public static void runThrough(DSAQueue test1) 
    {
	int numItems = 10;
	System.out.println("## TESTING QUEUE INSERT"); 
	System.out.println("\n\t** will try to insert this many items: " + numItems); 
	try
	{
	    for (int i = 10; i < 20  ; i++)
	    {
		System.out.print("Attempting to insert: " + i + " "); 
		test1.insert(i);
		System.out.println(" [success]🐸 "); 
	    }
	}
	catch (Exception e)
	{
	    System.out.println(e.getMessage()); 
	}
	System.out.println("EMPTY?: " + test1.isEmpty()); 
	try
	{
	    System.out.println("PEEK: " + test1.peek()); 
	}
	catch (Exception e)
	{
	    System.out.println(e.getMessage()); 
	}

	System.out.println("## TESTING QUEUE REMOVE"); 
	System.out.println("\n\t** will try to remove this many items: " + numItems); 
	try
	{
	    for (int i = 0; i < numItems  ; i++)
	    {
		System.out.print("Attempting to remove: " + test1.remove()); 
		System.out.println(" [success]🐸 "); 
	    }
	}
	catch (Exception e)
	{
	    System.out.println(e.getMessage()); 
	}
	System.out.println("EMPTY?: " + test1.isEmpty()); 
	try
	{
	    System.out.println("PEEK: " + test1.peek()); 
	}
	catch (Exception e)
	{
	    System.out.println(e.getMessage()); 
	}
    }
}
