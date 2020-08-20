
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
	int var = top;
	if (bottom != 0) // base case, when bottom = 0, we have found the gcf
	{
	    var = gcfRecur(bottom, (top % bottom)); /* bottom becomes top, and
	                      bottom is now the remainder of top and bottom */
	}
	return var;
    }
}
