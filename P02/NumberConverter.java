/* ***************************************************************************
 * NAME: NumberConverter.java
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: COMP1002 - Data Structures and Algorithms
 * PURPOSE: Integer value number converter (base 1-16)
 * COMMENT: https://www2.cs.arizona.edu/~mercer/Presentations/17B-RecursiveNumberConversion.pdf
 * DATE: 2020-08-20
 * **************************************************************************/
import java.util.*;

public class NumberConverter
{
    public static void main(String[] args)
    {
	int n = 64;
	System.out.println(convert(n, 2)); // binary (base 2)
	System.out.println(convert(n, 8)); // octal (base 8)
	System.out.println(convert(n, 10)); // decimal (base 10)
	System.out.println(convert(n, 16));  // hexadecimal (base 16)
    }
    
    public static String convert(int num, int base)
    {
	String var = "";
	try
	{
	    if (num == 0) // if we get a zero, do nothing
	    {
		var = "";
	    }
	    else
	    {
		// similar to doing it by hand, dividing by the base 
		// --> recursion makes 'sense' here, adding the numbers as it
		// winds back.
		var = convert(num / base, base) + (num % base); 
	    }
	}
	catch (Exception e)
	{
	    System.out.println(e.getMessage()); 
	}
	return var;
    }
}
