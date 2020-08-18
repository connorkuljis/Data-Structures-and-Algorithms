import java.util.*;

public class Fibonacci
{
    public static void main(String[] args)
    {
	long startTime, endTime;
	int total, n = 32; // to search for position in fibonacci
	System.out.println("### Comparing Fibonacci Recursive/Iterative"); 
	System.out.println("\t where n = " + n); 
	System.out.println(""); 

	/* timing fibonacci recursive*/
	System.out.println("### Recursive Fibonacci ###"); 
	startTime = System.nanoTime();
	System.out.println("\tFib value: " + fibRecursive (n)); // call to method
	endTime = System.nanoTime();
	total = (int)((double)(endTime - startTime) / 1000.0);
	System.out.println("\tTIME FOR Fibonacci Recursive: " + total); 
	// end recusive testing


	/* timing fibonacci (this time the iterative method)*/
	System.out.println("### Iterative Fibonacci ###"); 
	startTime = System.nanoTime();
	System.out.println("\tFib: " + fibonacci(n)); // call to method
	endTime = System.nanoTime();
	total = (int)((double)(endTime - startTime) / 1000.0);
	System.out.println("\tTIME FOR Fibonacci Iterative: " + total); 
	// end iterative testing

    }

    public static int fibRecursive(int n)
    {
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

    public static int fibonacci(int n)
    {
	int fib = 0;

	if (n >= 1) 
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
	else
	{
	    System.out.println("Invalid value of n"); 
	    fib = 0;
	}

	return fib;
    }
}
