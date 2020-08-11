/* ***************************************************************************
 * triangle.java
 * evaluates triangular numbers
 * set = {1, 3, 6, 10, 15, 21, ...}
 * n   = {1, 2, 3, 4 , 5 , 6 , ...}
 * The nth term in the series is obtained by adding n to the previous term. 
 * **************************************************************************/
import java.util.*;
class Triangle
{

    public static void main(String[] args)
    {
	int theNumber = 6;
	System.out.println("Enter a number: " + theNumber); 
	int theAnswer = triangle(theNumber);
	System.out.println("Triangle="+theAnswer); 
    }

    public static int triangle(int n)
    {
	System.out.println("Entering: n=" + n); 
	if (n == 1)
	{
	    System.out.println("returning 1"); 
	    return 1;
	}
	else
	{
	    int temp = ( n + triangle( n - 1 ) );
	    System.out.println("Returning: " + temp); 
	    return temp;
	}
    }
}
