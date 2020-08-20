/* ***************************************************************************
 * NAME: Factorial.java
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: COMP1002 - Data Structures and Algorithms
 * PURPOSE: investigate performance of factorial algortithm with increasing
 *          values of n.
 * COMMENT: from the tested values there is no much difference in speed 
 *          between the algorithms. The recursive method can use more space
 *          and memory -> possible stack overflow.
 * DATE: 2020-08-20
 * **************************************************************************/
import java.util.*;
public class Factorial
{
    public static void main(String[] args)
    {
	System.out.println("### Comparing Factorial Recursive/Iterative"); 
	System.out.println(""); 

	int stop = 10;

	System.out.println("### Recursive Factorial ###"); 
	for (int i = -4; i <= stop; i++)
	{
	    testRecursive(i);
	}

	System.out.println("### Iterative Factorial ###"); 
	for (int i = -4; i <= stop; i++)
	{
	    testIterative(i);
	}
    }

    public static void testRecursive(int n)
    {
	long startTime, endTime;
	int total;
	long fact = 0;

	/* RECURSIVE METHOD TEST ********************************************/
	startTime = System.nanoTime();

	try
	{
	    fact = factRecur(n);
	    endTime = System.nanoTime();
	    total = (int)((double)(endTime - startTime) / 1000.0);
	    System.out.println("\tn = " + n + "! =  " + fact + ", in (" + total + 
		    ") nanoseconds.");
	}
	catch (IllegalArgumentException e)
	{
	    System.out.println(e.getMessage()); 
	}
	// end recusive testing
    }

    public static void testIterative(int n)
    {
	long startTime, endTime;
	int total;
	long fact = 0;

	/* RECURSIVE METHOD TEST ********************************************/
	startTime = System.nanoTime();

	try
	{
	    fact = factIter(n);
	    endTime = System.nanoTime();
	    total = (int)((double)(endTime - startTime) / 1000.0);
	    System.out.println("\tn = " + n + "! =  " + fact + ", in (" + total + 
		    ") nanoseconds.");
	}
	catch (IllegalArgumentException e)
	{
	    System.out.println(e.getMessage()); 
	}
	// end recusive testing
    }

    public static long factIter(int n) throws IllegalArgumentException
    {
	if (n < 0)
	{
	    throw new IllegalArgumentException("value must be non-negative");
	}

	long nFactorial = 1;
	for (int ii = 1; ii <= n; ii++)
	{
	    nFactorial *= ii;
	}
	return nFactorial;
    }

    public static long factRecur(int n) throws IllegalArgumentException
    {
	if (n < 0)
	{
	    throw new IllegalArgumentException("value must be non-negative");
	}

	long var = 0;
	if (n == 0)
	{
	    var = 1;
	}
	else
	{
	    var = n * factRecur(n-1);
	}
	return var;
    }
}
