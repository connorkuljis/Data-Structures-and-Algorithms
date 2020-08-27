// https://en.wikipedia.org/wiki/Call_stack
import java.util.*;

public class CallStack
{
    // I have used a global variable here for the sake of simulating the call stack
    public static DSAStack stack = new DSAStack();

    public static void main(String[] args)
    {
	int nCalls = 5;
	functionRecur(nCalls);
    }
    
    public static void functionRecur(int n)
    {
	if (n == 0)
	{
	    System.out.println(""); 
	    return;
	}

	String methodName = "functionRecur(" + Integer.toString(n) + ")";
	insertStack(methodName);
	functionRecur(n-1);
	popStack(methodName);
    }

    public static void functionNested(int n)
    {

    }

    public static void insertStack(String methodName)
    {
	stack.push(methodName);
	System.out.println("Adding the method: " + methodName + " to the stack frame."); 
    }

    public static void popStack(String methodName)
    {
	System.out.println("Removing the method: " + stack.pop() + " from the stack frame.");
    }

    

}
