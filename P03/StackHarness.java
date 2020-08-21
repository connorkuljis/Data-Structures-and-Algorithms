import java.util.*;

public class StackHarness
{
    public static void main(String[] args)
    {
        DSAStack test = new DSAStack();
        System.out.println(test.isFull()); 

        DSAStack dates = new DSAStack(50);
        dates.push(65.0);

        dates.push(128.5);
        dates.push("Hello");
        System.out.println(dates.top()); 
        System.out.println(dates.top().getClass()); 
    }
}
