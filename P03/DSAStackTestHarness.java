/* ***************************************************************************
 * NAME: DSAStackTestHarness.java
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT:
 * PURPOSE:
 * COMMENT:
 * DATE:
 * **************************************************************************/
import java.util.*;

public class DSAStackTestHarness
{
    public static void main(String[] args)
    {
	int n, overcapacity;
	n = 5;
	overcapacity = n + 1;

	System.out.println("### TESTING DSA STACK"); 
	System.out.println("\n\t## TESTING PUSH"); 
        DSAStack test = new DSAStack(n);

	try
	{
	    for (int i = 0; i < overcapacity ; i++)
	    {
		System.out.print("Attempting to push: " + i + " "); 
		test.push(i);
		System.out.println(" [success]🐸 "); 
	    }
	}
	catch (Exception e)
	{
	    System.out.println(e.getMessage()); 
	}
	System.out.print("Display: "); 
	test.display();
	System.out.println("Is the stack empty: " + test.isEmpty()); 
	System.out.println("Is the stack full: " + test.isFull()); 

	System.out.println("\n\t## TESTING POP"); 
	try
	{
	    for (int i = 0; i < overcapacity ; i++)
	    {
		System.out.print("Attempting to pop: " + test.pop() + " "); 
		System.out.println(" [success]🐸 "); 
	    }
	}
	catch (Exception e)
	{
	    System.out.println(e.getMessage()); 
	}
	System.out.print("Display: "); 
	test.display();
	System.out.println("Is the stack empty: " + test.isEmpty()); 
	System.out.println("Is the stack full: " + test.isFull()); 







    }
}
