import java.util.*;

public class CallStack
{
    public static DSAStack stack = new DSAStack();

    public static void main(String[] args)
    {
	int nCalls = 5;
	makeACall(nCalls);
    }
    
    public static void makeACall(int n)
    {
	if (n == 0)
	{
	    return;
	}

	String methodName = "makeACall(" + Integer.toString(n) + ")";
	System.out.println("Push: " + methodName); 

	stack.push(methodName);
	makeACall(n-1);
	System.out.println("Pop: " + stack.pop());


    }
    

}
