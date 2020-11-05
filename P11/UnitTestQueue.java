/* ***************************************************************************
 * NAME: UnitTestQueue
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: DSA
 * PURPOSE: test harness for queues USING IN BUILD TYPES
 * COMMENT:
 * DATE: 2020-11-05
 * **************************************************************************/
import java.util.*;
import java.util.LinkedList; 
import java.util.Queue; 

public class UnitTestQueue
{
    public static void main(String[] args)
    {
	Queue<Integer> test1 = new LinkedList<Integer>();

	int numItems = 10;
	System.out.println("## TESTING QUEUE INSERT"); 
	System.out.println("\n\t** will try to insert this many items: " + numItems); 
	try
	{
	    for (int i = 0; i < numItems  ; i++)
	    {
		System.out.print("Attempting to insert: " + i + " "); 
		test1.offer(i);
		System.out.println(" [success]🐸 "); 
	    }
	}
	catch (Exception e)
	{
	    System.out.println(e.getMessage()); 
	}
	System.out.println("EMPTY?: " + test1.isEmpty()); 
	System.out.println("SIZE: " + test1.size()); 
	System.out.println("PEEK: " + test1.peek()); 

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
	System.out.println("SIZE: " + test1.size()); 
	System.out.println("PEEK: " + test1.peek()); 
    }
}
