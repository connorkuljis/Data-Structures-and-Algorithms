/* ***************************************************************************
 * NAME: Gcf.java
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: COMP1002 - Data Structures and Algorithms
 * PURPOSE: implementing a recursive greatest common factor algorithm
 * COMMENT:
 * DATE:
 * **************************************************************************/
import java.util.*;

public class Gcf
{
    public static void main(String[] args)
    {
	int a = 1000, b = 128;
	int result = gcfRecur(a, b);
	System.out.println("GCF of " + a + " and " + b + " is: " + result); 
    }

    public static int gcfRecur(int top, int bottom)
    {
	int var = 0;
	try
	{
	    System.out.println("top: " + top + ", bottom: " + bottom); 
	    var = top;
	    if (bottom != 0) // base case, when bottom = 0, we have found the gcf
	    {
		// some swapping going on
		var = gcfRecur(bottom, (top % bottom)); /* bottom becomes top, and
				  bottom is now the remainder of top and bottom */
	    }
	}
	catch (Exception e)
	{
	    System.out.println(e.getMessage()); 
	    // alternatively throw exception and pass it to caller
	}
	return var;
    }
}
