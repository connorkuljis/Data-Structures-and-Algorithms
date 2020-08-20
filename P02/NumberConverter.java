import java.util.*;

public class NumberConverter
{
    public static void main(String[] args)
    {
	System.out.println(convert(99,2)); 
    }
    
    /* ***********************************************************************
     * IMPORTS: num, base (integers)
     * EXPORTS: 
     * PURPOSE:
     * **********************************************************************/
    public static String convert(int num, int base)
    {
	if (num == 0)
	{
	    return "";
	}
	else
	{
	    return convert(num / base, base) + (num % base); 
	}
    }
}
