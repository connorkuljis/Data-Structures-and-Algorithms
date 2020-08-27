/* ***************************************************************************
 * NAME: DSAQueueTestHarness.java
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: DSA
 * PURPOSE: test harness for DSA Queue (both types)
 * COMMENT:
 * DATE: 28-08-2020
 * **************************************************************************/
import java.util.*;

public class DSAQueueTestHarness
{
    public static void main(String[] args)
    {
	DSAQueue test = null; // showing polymorphism
	String choice = "";
	int size = 0;
	try
	{
	    choice = args[0];
	    size = Integer.parseInt(args[1]);
	}
	catch (Exception e)
	{
	    System.out.println("You have not entered (c)ircular or (s)huffle with size, on the command line argument"); 
	    System.out.println("eg: java DSAQueueTestHarness c 10. "); 
	    System.out.println("c is the type and 10 is the capacity"); 
	    throw new IllegalArgumentException("");
	}

	System.out.println("### TESTING QUEUE");
	System.out.println("\tCAPACITY=" + size); 
	switch(choice)
	{
	    case "c":
		test = new DSACircularQueue(size);
		break;

	    case "s":
		test = new DSAShuffleQueue(size);
		break;

	    default:
		System.out.println("You have not entered (c)ircular or (s)huffle with size, on the command line argument"); 
		break;
	}
	runThrough(test);

    }

    public static void runThrough(DSAQueue test1) // showing polymorphism
    {
	int numItems = 10;
	System.out.println("## TESTING QUEUE INSERT"); 
	System.out.println("\n\t** will try to insert this many items: " + numItems); 
	try
	{
	    for (int i = 0; i < numItems  ; i++)
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
	System.out.println("FULL?: " + test1.isFull()); 
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
	System.out.println("FULL?: " + test1.isFull()); 
	System.out.println("SIZE: " + test1.size()); 
	System.out.println("PEEK: " + test1.peek()); 
    }
}
