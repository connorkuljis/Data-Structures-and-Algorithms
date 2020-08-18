import java.util.*;

public class Gcf
{
    public static void main(String[] args)
    {
	gcfRecur(12, 3);

    }

    /* imports: top, bottom (integers)
     * exports: none
     * purpose: 
     */
    public static void gcfRecur(int top, int bottom)
    {
	if (bottom == 1)  // base case. 
	{
	    System.out.println("ending"); 
	}
	else if (bottom % 2 != 0) // if cannot be further divided by 2
	{
	    System.out.println("Cannot divide"); 
	}
	else
	{
	    System.out.println("Checking: " + top); 
	    System.out.println("Greatest Common Factor?: " + bottom); 
	    int temp = bottom - 1;
	    gcfRecur(top, temp);
	}
    }
}
