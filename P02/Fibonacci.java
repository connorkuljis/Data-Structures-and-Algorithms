/* ***************************************************************************
 * NAME: Fibonacci.java
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: COMP1002 - Data Structures and Algorithms
 * PURPOSE: investigate performance of fibonacci algortithm with increasing
 *          values of n.
 * COMMENT: using the iterative method was far quicker
 * DATE: 2020-08-20
 * **************************************************************************/
import java.util.*;

public class Fibonacci
{
    public static void main(String[] args)
    {
	System.out.println("### Comparing Fibonacci Recursive/Iterative"); 
	System.out.println(""); 

	System.out.println("### Recursive Fibonacci ###"); 
	for (int i = -4; i <= 32; i = i + 4)
	{
	    testRecursive(i);
	}

	System.out.println("### Iterative Fibonacci ###"); 
	for (int i = -4; i <= 32; i = i + 4)
	{
	    testIterative(i);
	}
    }

    public static void testRecursive(int n)
    {
	long startTime, endTime;
	int total, fibVal = 0;

	/* RECURSIVE METHOD TEST ********************************************/
	startTime = System.nanoTime();

	try
	{
	    fibVal = fibRecursive(n);
	    endTime = System.nanoTime();
	    total = (int)((double)(endTime - startTime) / 1000.0);
	    System.out.println("\tn = " + n + ", Fib value: " + fibVal + ", in (" + total + 
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
	int total, fibVal = 0;

	startTime = System.nanoTime();
	try
	{
	    fibVal = fibonacci(n);
	    endTime = System.nanoTime();
	    total = (int)((double)(endTime - startTime) / 1000.0);
	    System.out.println("\tn = " + n + ", Fib value: " + fibVal + ", in (" + total + 
		    ") nanoseconds.");
	}
	catch (IllegalArgumentException e)
	{
	    System.out.println(e.getMessage()); 
	}
	// end iterative testing
    }

    public static int fibRecursive(int n) throws IllegalArgumentException
    {
	if (n < 0)
	{
	    throw new IllegalArgumentException("n must be a " + 
		    "non-negative number");
	}

	int fibVal = 0; // initialize
	if (n <= 0)      // base case #1
	{
	    fibVal = 0;
	}
	else if (n == 1) // base case #2
	{
	    fibVal = 1;
	}
	else
	{
	    /* very much similar to mathematical definition */
	    fibVal = fibRecursive(n-1) + fibRecursive(n-2); 
	}

	return fibVal;
    }

    public static int fibonacci(int n) throws IllegalArgumentException
    {
	int fib;

	if (n < 0)
	{
	    throw new IllegalArgumentException("n must be a " + 
		    "non-negative number");
	}
	if (n == 0)
	{
	    fib = 0;
	}
	else
	{
	    fib = 1;
	    int prevFib = 1;

	    for (int i = 2; i < n; i++)
	    {
		/* similar structure to how bubble sort swaps
		   it is comparing two adjacent values in an array */
		int temp = fib;
		fib = fib + prevFib;
		prevFib = temp;
	    }
	}
	return fib;
    }
}
