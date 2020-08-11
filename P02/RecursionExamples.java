/* ****************************************************************************
 * This is a java file with some recursion examples.
 * 
 * Recursion can simply be defined as a method that calls itself.
 * The only other rule is that recursive methods need a base case:
 *
 * BASE CASE: It stop the function to call itself when specific condition 
 *     matches. There can be more than one base case(s).
 *
 * GENERAL CASE: It calls function from within the function.
 * ***************************************************************************/

public class RecursionExamples
{
    public static void main( String[] args )
    {
	// 5! = 5 * 4 * 3 * 2 * 1 = 120
	
	// System.out.println(calcNFactorial(5)); 
	
	// System.out.println(calcNFactorialRecursive(5)); 

	// sayHi(5);

	// printNumbers(10);

	// System.out.println( numCatEyes(10) );

	// System.out.println(power(2, 6));
	
	int n = 8;
	System.out.println("Fibonacci value at " + n + " is: " + fibRecursive(n));

	System.out.println(fibonacci(8)); 
    }

    /* print numbers from 5 to 1 without loops */
    public static void printNumbers(int num)
    {
	if (num == 0) // base case
	{
	    return;
	}
	else
	{
	    System.out.println(num); 
	    printNumbers(num - 1);
	}
    }

    /* each cat has 2 eyes, find the total amount of eyes given the number of cats */
    public static int numCatEyes( int cats )
    {
	if (cats == 0)
	{
	    return 0;
	}
	else
	{
	    return 2 + numCatEyes(cats - 1);
	}
    }

    public static void sayHi( int n )
    {
	if (n == 0)
	{
	    System.out.println("done"); 
	}
	else
	{
	    System.out.println("hi"); 
	    n--;
	    sayHi(n);
	}
    }

    public static int power(int base, int num)
    {
	if (num == 1 ) // base case
	{
	    return base;
	}
	else
	{
	    return base * power(base, num - 1);
	}
    }

    public static long calcNFactorial( int n ) // this is the iterative implementation
    {
	long nFactorial = 1;
	for (int ii = 1; ii <= n; ii++)
	{
	    nFactorial *= ii;
	}
	return nFactorial;
    }

    public static long calcNFactorialRecursive( int n )
    {
	if ( n == 0 )
	{
	    return 1;
	}
	else
	{
	    return n * calcNFactorialRecursive( n-1 );
	}
    }

    public static int fibonacci(int n)
    {
	if (n <= 1) 
	{ 
	    return n;
       	}

	int fib = 1;
	int prevFib = 1;

	for (int i = 2; i < n; i++)
	{
	    int temp = fib;
	    fib = fib + prevFib;
	    prevFib = temp;
	}
	return fib;
    }

    public static int fibRecursive(int n)
    {
	// base case
	int fibVal = 0;

	if (n == 0)
	{
	    fibVal = 0;
	}
	else if (n == 1)
	{
	    fibVal = 1;
	}
	else
	{
	    fibVal = fibRecursive(n-1) + fibRecursive(n-2);
	}
	return fibVal;
    }
}
